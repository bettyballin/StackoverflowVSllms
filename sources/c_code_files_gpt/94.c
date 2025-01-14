#include <stdio.h>
#include <string.h>

int main() {
    char buffer[100];
    FILE *stream = fmemopen(buffer, sizeof(buffer), "w+");
    if (stream == NULL) {
        perror("fmemopen");
        return 1;
    }

    // Potential uninitialized use warning
    fprintf(stream, "Hello, World!");
    fclose(stream);

    return 0;
}