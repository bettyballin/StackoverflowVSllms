#include <stdio.h>
#include <stdlib.h>

// Define a function to reset the system
void reset_system() {
    printf("System reset!\n");
    // You can replace this with your actual system reset logic
    exit(0);
}

// Define the watchdog handler function
void watchdog_handler() {
    // Reset the system if the watchdog timer expires
    reset_system();
}

int main() {
    printf("Watchdog timer started...\n");
    // Simulate a watchdog timer expiration
    watchdog_handler();
    return 0;
}