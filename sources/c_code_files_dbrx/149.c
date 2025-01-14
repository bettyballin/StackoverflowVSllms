#include <stdlib.h>

int main() {
    void* ptr = malloc(10); // Allocate some memory
    free(ptr);
    ptr = NULL;
    return 0;
}