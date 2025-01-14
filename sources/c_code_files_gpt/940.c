#include <stdio.h>
#include <time.h>

// Function to be timed
void myFunction() {
    // Simulate some work with a sleep
    for (volatile int i = 0; i < 1000000000; ++i);
}

int main() {
    clock_t start, end;
    double cpu_time_used;

    // Start the clock
    start = clock();

    // Call the function you want to time
    myFunction();

    // Stop the clock
    end = clock();

    // Calculate the elapsed time
    cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;

    printf("myFunction() took %f seconds to execute\n", cpu_time_used);

    return 0;
}