#include <stdint.h>
#include <stdio.h>

uint32_t phase_accumulator = 0;  // 32-bit accumulator
uint32_t NCO_param = 12345;      // NCO parameter determining frequency

void clock_tick() {
    phase_accumulator += NCO_param;  // Increment phase accumulator
    // The phase accumulator will naturally roll-over due to 32-bit overflow
}

int main() {
    // Simulate clock ticks
    for (int i = 0; i < 10; i++) {
        clock_tick();
        printf("Phase accumulator: %u\n", phase_accumulator);
    }
    return 0;
}