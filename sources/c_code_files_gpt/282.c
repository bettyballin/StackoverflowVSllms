#include <stdint.h>
#include <stdbool.h>
#include <stdio.h> // Include stdio.h for printf

// Function prototypes
uint16_t generate_pseudo_random_id(uint16_t seed);
bool is_id_used(uint16_t id);
uint16_t get_next_unique_id(void);

// Global variable to keep track of the last used identifier
static uint16_t last_used_id = 0;

uint16_t generate_pseudo_random_id(uint16_t seed) {
    // Simple pseudo-random number generator (e.g., linear congruential generator)
    return (seed * 1103515245 + 12345) & 0xFFFF;
}

bool is_id_used(uint16_t id) {
    // Implement the logic to check if the ID is already used in the external Flash
    // This will involve SPI transactions and scanning through the Flash
    // Return true if the ID is used, false otherwise
    // Dummy implementation for illustration:
    return false; // Replace with actual check
}

uint16_t get_next_unique_id(void) {
    uint16_t seed = last_used_id;
    uint16_t new_id;

    // First try with pseudo-random numbers
    for (int i = 0; i < 100; ++i) { // Limit the number of attempts to avoid infinite loops
        new_id = generate_pseudo_random_id(seed);
        if (!is_id_used(new_id)) {
            last_used_id = new_id;
            return new_id;
        }
        seed = new_id; // Update seed for the next iteration
    }

    // Fallback to sequential incrementing
    new_id = last_used_id;
    do {
        new_id++;
        if (new_id == 0xFFFF) new_id = 1; // Wrap around if necessary
    } while (is_id_used(new_id));

    last_used_id = new_id;
    return new_id;
}

int main() {
    // Example usage
    uint16_t unique_id = get_next_unique_id();
    printf("Generated unique ID: %u\n", unique_id);
    return 0;
}