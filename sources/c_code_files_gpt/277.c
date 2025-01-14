#include <stdio.h>
#include <stdlib.h>
#include <sys/resource.h>

void set_stack_size_limit(size_t size) {
    struct rlimit rl;
    rl.rlim_cur = size;
    rl.rlim_max = size;
    if (setrlimit(RLIMIT_STACK, &rl) != 0) {
        perror("setrlimit");
        exit(EXIT_FAILURE);
    }
}

int recursive_function(int n) {
    if (n == 0) return 0;
    return 1 + recursive_function(n - 1);
}

int main() {
    // Set stack size to 16 MB
    set_stack_size_limit(16 * 1024 * 1024);

    // Call your recursive function
    int result = recursive_function(128000);
    printf("Result: %d\n", result);

    return 0;
}