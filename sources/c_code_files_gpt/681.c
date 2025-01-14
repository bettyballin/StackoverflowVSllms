#include <stdio.h>

typedef struct {
    int len;
} psd_t;

int main() {
    psd_t *psd = &(psd_t){0}; // Initialize a psd_t struct with len = 0
    int len = 10; // Define a length to add to psd->len

    psd->len += len; // The original line of code

    printf("psd->len = %d\n", psd->len); // Print the result

    return 0;
}