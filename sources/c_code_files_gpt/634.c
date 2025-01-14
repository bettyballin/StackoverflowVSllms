// Using fread()
#include <stdio.h>

int main() {
    FILE *file = fopen("example.txt", "r");
    if (file == NULL) {
        perror("fopen");
        return 1;
    }

    char buffer[128];
    size_t bytesRead = fread(buffer, 1, sizeof(buffer), file);
    if (bytesRead < sizeof(buffer) && ferror(file)) {
        perror("fread");
        return 1;
    }

    // Process buffer...
    fclose(file);
    return 0;
}