#include <stdio.h>

// Function prototype for callb
void callb(void);

// Define a simple implementation for callb
void callb(void) {
    printf("Callback function called\n");
}

void test(void) {
    printf("here, in lib\n");
    callb();
}

int main() {
    test();
    return 0;
}