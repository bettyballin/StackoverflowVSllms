#include <stdlib.h>

int main(int argc, char* argv[])
{
    int* sieve = (int*)calloc(2000000, sizeof(int));
    if (sieve == NULL) {
        // Handle allocation failure
        return 1;
    }

    // Use the array here

    // Free the allocated memory
    free(sieve);

    return 0;
}