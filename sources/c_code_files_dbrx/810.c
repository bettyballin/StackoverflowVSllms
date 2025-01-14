#include <stdio.h>

#define SIZE 1024*64 // adjustable based on testing

// Placeholder function to do work on the short array
void doWorkOnShortArray(short* array, size_t size) {
    // Example operation: printing the first and last elements
    printf("First element: %hd\n", array[0]);
    printf("Last element: %hd\n", array[SIZE - 1]);
}

int main() {
    int array[SIZE];
    // Example initialization: setting all elements to their index value
    for (size_t i = 0; i < SIZE; ++i) {
        array[i] = i;
    }

    short s_array[SIZE];
    for(size_t i = 0; i < SIZE; ++i) {
        s_array[i] = (short)array[i];
    }
    doWorkOnShortArray(s_array, SIZE);

    return 0;
}