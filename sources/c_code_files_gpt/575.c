#include <signal.h>
#include <setjmp.h>
#include <unistd.h>
#include <stdbool.h>

static sigjmp_buf jumpBuffer;

void signalHandler(int sig) {
    siglongjmp(jumpBuffer, 1);
}

bool isValidPointer(void* ptr) {
    struct sigaction sa, old_sa;
    sa.sa_handler = signalHandler;
    sigemptyset(&sa.sa_mask);
    sa.sa_flags = 0;
    sigaction(SIGSEGV, &sa, &old_sa);

    if (sigsetjmp(jumpBuffer, 1) == 0) {
        // Attempt to read from the memory address
        volatile char temp = *(volatile char*)ptr;
        (void)temp;
        sigaction(SIGSEGV, &old_sa, NULL);
        return true;
    } else {
        sigaction(SIGSEGV, &old_sa, NULL);
        return false;
    }
}

int main() {
    // Test the function
    int* valid_ptr = &valid_ptr;
    int* invalid_ptr = (int*)0x12345678;

    printf("Is valid_ptr valid? %s\n", isValidPointer(valid_ptr) ? "yes" : "no");
    printf("Is invalid_ptr valid? %s\n", isValidPointer(invalid_ptr) ? "yes" : "no");

    return 0;
}