#include <stdio.h>

int main() {
    FILE *file = fopen("example.txt", "a");
    if (file != NULL) {
        fputc('\n', file);
        fclose(file);
    }
    return 0;
}