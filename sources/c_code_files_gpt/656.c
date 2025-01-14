// file1.c
#include <stdio.h> // Include the standard input/output library for printf

static int counter = 0; // This variable is only visible within file1.c

static void incrementCounter() { // This function is only visible within file1.c
    counter++;
}

int main() {
    // Call the incrementCounter function a few times
    incrementCounter();
    incrementCounter();
    incrementCounter();

    // Print the final value of the counter
    printf("Counter value: %d\n", counter);

    return 0; // Return 0 to indicate successful execution
}