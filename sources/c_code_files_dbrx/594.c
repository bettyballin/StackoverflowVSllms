#include <stdio.h>

int main() {
    FILE *f = fopen("blah", "w");
    // Doing something with "f".
    fclose(f);
    return 0;
}