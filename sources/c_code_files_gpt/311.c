#include <stdio.h>

// Ensure the array data is aligned to a 16-byte boundary
float data[4] __attribute__((aligned(16)));

int main() {
    // Initialize the data array
    for (int i = 0; i < 4; i++) {
        data[i] = (float)i;
    }

    // Print the data to verify alignment and contents
    printf("Address of data: %p\n", (void*)&data[0]);
    for (int i = 0; i < 4; i++) {
        printf("data[%d] = %f\n", i, data[i]);
    }

    return 0;
}