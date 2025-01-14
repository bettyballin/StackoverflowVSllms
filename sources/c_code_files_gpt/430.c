#include <stdio.h>
#include <stdint.h>

// Simple structure to represent a CPU mask
typedef struct {
    uint32_t bits[1]; // Adjust size as needed
} cpumask_t;

// Function to "and" two masks
void cpu_mask_and(cpumask_t *dst, const cpumask_t *src1, const cpumask_t *src2) {
    dst->bits[0] = src1->bits[0] & src2->bits[0];
}

int main() {
    cpumask_t mask1, mask2, result;

    // Initialize masks
    mask1.bits[0] = 0x0000000F; // CPUs 0-3
    mask2.bits[0] = 0x00000003; // CPUs 0-1

    // Perform AND operation
    cpu_mask_and(&result, &mask1, &mask2);

    printf("Resulting mask: 0x%08X\n", result.bits[0]);

    return 0;
}