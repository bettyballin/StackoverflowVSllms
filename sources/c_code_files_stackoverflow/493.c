#include <stdio.h>
#include <sys/time.h>

// Define GetTickCount function, which is not a standard C function
// but rather a Windows API function. We'll use a similar function
// to get the time in milliseconds.
int GetTickCount() {
    struct timeval tv;
    gettimeofday(&tv, NULL);
    return tv.tv_sec * 1000 + tv.tv_usec / 1000;
}

int main() {
    // Call the _CAP_Enter_Function and _CAP_Exit_Function
    // to test them
    _CAP_Enter_Function(main);
    printf("Inside main function\n");
    _CAP_Exit_Function(main);
    return 0;
}

void _CAP_Enter_Function(void *p) {
    if (p != main)
        printf("Enter function   (at address %p) at %d\n", p, GetTickCount());
    return;
}

void _CAP_Exit_Function(void *p) {
    if (p != main)
        printf("Leaving function (at address %p) at %d\n", p, GetTickCount());
    return;
}