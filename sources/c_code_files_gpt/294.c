#include <stdint.h>
#include <stdio.h>

uint32_t read_cycle_count() {
    uint32_t cycle_count;
    // Assuming there is a special function or register to read the cycle count
    cycle_count = *(volatile uint32_t *)0xYourCycleCountRegisterAddress; 
    return cycle_count;
}

int main() {
    uint32_t start, stop, total;
    int i;

    start = read_cycle_count();
    for (i = 0; i < 100; i++) {
        // Do something here
    }
    stop = read_cycle_count();
    total = stop - start;

    // Assuming there's a way to print or share these values with the ARM processor
    printf("Total clock cycles = %u\n", total);
    printf("Start cycle count = 0x%x\n", start);
    printf("Stop cycle count = 0x%x\n", stop);

    return 0;
}