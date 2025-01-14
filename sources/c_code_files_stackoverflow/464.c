#include <stdio.h>

int main() {
    void* var = NULL;  // Declare var as a void pointer and initialize it to NULL
    if (var == NULL) {  // Compare var to NULL using the comparison operator
        printf("var is NULL\n");
    }
    return 0;
}