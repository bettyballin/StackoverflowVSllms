#include <stdio.h>
#include <stdint.h>

int main() {
    uint32_t petvar = 0; // Initialize petvar to 0 for demonstration
    uint16_t rnd = 123;  // Initialize rnd for demonstration
    
    petvar = (petvar ^ rnd) << 16 | rnd;
    
    printf("Result: %u\n", petvar); // Print the result for verification
    
    return 0;
}