#include <stdio.h>
#include <stdlib.h>

void takes_a_long(long sad_story) {
    printf("Long %lu\n", sad_story);
}

void takes_a_float(float my_boat) {
    printf("Float %f\n", my_boat);
}

int main(int argc, char **argv) {
    float my_boat = 1.0f;
    long sad_story = 1L; // Changed 1.0L to 1L, as long is an integer type

    // No warnings wanted
    takes_a_float(my_boat);
    takes_a_long(sad_story);

    // Suppress warnings for specific cases
    #pragma GCC diagnostic push
    #pragma GCC diagnostic ignored "-Wconversion"

    // Warnings suppressed
    takes_a_long((long)my_boat); // Added cast to long
    takes_a_float((float)sad_story); // Added cast to float

    // Re-enable warnings
    #pragma GCC diagnostic pop

    return 0; // Changed exit(0) to return 0
}