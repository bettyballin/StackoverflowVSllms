#include <stdio.h>

int main() {
    int steps = 10; // Define the number of steps
    int size = 10; // Define the size
    float a __attribute__((vector_size(16))) = {1.0, 2.0, 3.0, 4.0}; // Initialize a
    float b __attribute__((vector_size(16))) = {5.0, 6.0, 7.0, 8.0}; // Initialize b

    for (int j = 0; j < steps; ++j) {
        for (int i = 0; i < size; i++) {
            __builtin_ia32_vdpusdXmm(a, b); /* Sum */
        }
    }

    return 0;
}