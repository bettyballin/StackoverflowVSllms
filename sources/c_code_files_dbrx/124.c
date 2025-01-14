#include <stdio.h>

int main() {
    FILE *stream = fopen("file.txt", "r");
    if (stream == NULL) {
        printf("Failed to open file\n");
        return 1;
    }

    // Read as much data as possible from 'stream'
    // ...

    if (feof(stream)) {
        // End of File reached
    }
    fclose(stream);

    if (stream == NULL) {
        printf("File is closed\n");
    } else {
        printf("File pointer is not NULL after fclose()\n");
    }

    return 0;
}