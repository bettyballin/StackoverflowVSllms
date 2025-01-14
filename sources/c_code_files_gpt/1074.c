#include <stdio.h>

// Define the testlib function to make the code executable
int testlib(void) {
    printf("This is a test library function.\n");
    return 0; // Return a value to match the function signature
}

int main() {
    // Call testlib in main to demonstrate its execution
    int result = testlib();
    printf("Result from testlib: %d\n", result);
    return 0;
}