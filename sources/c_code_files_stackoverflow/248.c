#include <stdio.h>

// Assuming LOW_PRIO_ISR and HIGH_PRIO_ISR are global variables
volatile int LOW_PRIO_ISR = 0;
volatile int HIGH_PRIO_ISR = 0;

void low_prio_isr(void)
{
    LOW_PRIO_ISR = 1;
    if (1 == HIGH_PRIO_ISR)
    {
        // this may never happen. dummy statement to allow breakpoint in debugger
        printf("Unreachable code\n");
    }
}

void high_prio_isr(void)
{
    HIGH_PRIO_ISR = 1;
}

int main()
{
    return 0;
}