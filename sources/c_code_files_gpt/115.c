#include <stdio.h>
#include <stdlib.h>

void* mallocStuff(int x, int y) {
    return malloc(1); // Allocate a small block of memory for demonstration purposes
}

int main() {
    void* translatedArray[2];

    translatedArray[0] = mallocStuff(0, 0);
    translatedArray[1] = mallocStuff(0, 0);

    printf("block size (for a): %p-%p : %li\n",
        translatedArray[1], translatedArray[0], (long int)translatedArray[1] - (long int)translatedArray[0]);

    free(translatedArray[0]);
    free(translatedArray[1]);

    return 0;
}