#include <stdio.h>
#include <time.h>

// Dummy functions to simulate interrupt handling
void init_interrupts() {
    printf("Initializing interrupts...\n");
}

void enable_interrupt() {
    printf("Enabling interrupts...\n");
}

void disable_interrupt() {
    printf("Disabling interrupts...\n");
}

void generate_interrupt() {
    printf("Generating interrupt...\n");
}

void high_priority_isr() {
    printf("Executing high priority ISR...\n");
}

void low_priority_isr() {
    printf("Executing low priority ISR...\n");
}

// Function to measure latency
double measure_interrupt_latency(void (*isr)()) {
    struct timespec start, end;
    clock_gettime(CLOCK_MONOTONIC, &start);
    
    // Simulate interrupt generation
    generate_interrupt();

    // ISR should be executed here
    isr();

    clock_gettime(CLOCK_MONOTONIC, &end);
    double latency = (end.tv_sec - start.tv_sec) * 1e9;
    latency = (latency + (end.tv_nsec - start.tv_nsec)) * 1e-9;
    
    return latency;
}

int main() {
    init_interrupts();
    enable_interrupt();

    double high_priority_latency = measure_interrupt_latency(high_priority_isr);
    double low_priority_latency = measure_interrupt_latency(low_priority_isr);

    printf("High Priority Interrupt Latency: %f seconds\n", high_priority_latency);
    printf("Low Priority Interrupt Latency: %f seconds\n", low_priority_latency);

    disable_interrupt();
    
    return 0;
}