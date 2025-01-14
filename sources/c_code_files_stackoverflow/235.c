#include <stdlib.h>

int main() {
    int *sieve = malloc(2000000 * sizeof(*sieve));
    free(sieve); // don't forget to free the memory
    return 0;
}