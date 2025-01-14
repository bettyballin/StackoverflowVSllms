#include <stdio.h>

int main() {
    FILE *f = fopen("blah", "w"); // Corrected to use a pointer to FILE
    if (f != NULL) {
        fclose(f); // Corrected to pass the pointer directly
    }
    return 0;
}