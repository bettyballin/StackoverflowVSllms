#include <stdio.h>

int main() {
    // Define some example values for actual function execution time and subroutine times
    int actual_function_execution = 100;
    int subroutine1_time = 20;
    int subroutine2_time = 30;

    // Exclusive time: Time spent exclusively in this function
    int exclusive_time = actual_function_execution - subroutine1_time - subroutine2_time;

    // Inclusive time: Includes both the function execution time as well as any functions it calls.
    int inclusive_time = exclusive_time + subroutine1_time + subroutine2_time;

    // Print the results
    printf("Exclusive time: %d\n", exclusive_time);
    printf("Inclusive time: %d\n", inclusive_time);

    return 0;
}