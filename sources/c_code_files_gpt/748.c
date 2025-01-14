#include <stdio.h>

int main() {
    FILE* f = fopen("blah", "w");
    if (f != NULL) {
        // Use the file
        fclose(f);
    }
    return 0;
}