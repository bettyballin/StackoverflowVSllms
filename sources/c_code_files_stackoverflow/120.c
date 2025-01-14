#include <stdlib.h>

int main() {
    short int* translatedArray;
    translatedArray = malloc(4 * sizeof(short int));
    // Don't forget to free the memory when you're done
    free(translatedArray);
    return 0;
}