#include <stdio.h>
#include <stdlib.h>

int main() {
    void* a = malloc(16);
    void* b = malloc(16);
    printf("block size (for a): %p-%p : %li\n", b, a, (long int)b-(long int)a);
    free(a);
    free(b);
    return 0;
}