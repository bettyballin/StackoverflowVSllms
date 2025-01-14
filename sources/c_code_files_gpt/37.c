#include <stdint.h>
#include <stdio.h>

// Assume these functions are provided by your embedded system's hardware abstraction layer (HAL)
extern uint32_t getTimerValue();
extern void resetTimer();

// Define the TIMER_FREQUENCY constant
#define TIMER_FREQUENCY 1000 // Replace with actual timer frequency

void yourFunction() {
    // Your function code here
}

int main() {
    uint32_t start, end;
    double time_in_milliseconds;

    resetTimer();
    start = getTimerValue();
    yourFunction();
    end = getTimerValue();
    
    time_in_milliseconds = (double)(end - start) / (double)TIMER_FREQUENCY;

    printf("Function execution time: %f milliseconds\n", time_in_milliseconds);

    return 0;
}