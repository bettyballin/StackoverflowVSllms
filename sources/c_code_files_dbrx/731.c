#include <stdio.h>
#include <time.h>

void myFunction() {
    // Your code here
    // For demonstration, let's add something to do
    int sum = 0;
    for (int i = 0; i < 100000000; i++) {
        sum += i;
    }
    printf("Sum calculated: %d\n", sum);
}

int main(void) {
    clock_t start, end;
    double cpu_time_used;

    start = clock();

    myFunction(); // your function to measure

    end = clock();
    cpu_time_used = ((double)(end - start)) / CLOCKS_PER_SEC;

    // Output time taken in seconds
    printf("Time used = %f\n", cpu_time_used);

    return 0; // Explicit return statement for clarity
}