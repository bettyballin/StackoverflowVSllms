#include <stdlib.h>

int main() {
    int size = 10; // define the size variable
    // Allocate on heap (recommended)
    int* buffer = (int*)malloc(sizeof(int)*size);
    // ... use the 'buffer' here
    free(buffer); // don't forget to deallocate
    return 0;
}