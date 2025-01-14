#include <stdio.h>

// Define the testlib function to make the code executable
int testlib(void) {
    printf("This is a test library function.\n");
    return 0; // Return a value as the function is declared to return int
}

int main() {
    // Call testlib to use it
    int result = testlib();
    printf("Result from testlib: %d\n", result);
    return 0;
}