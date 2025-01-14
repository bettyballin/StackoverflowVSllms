#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

int atomic_write(const char *filename, const char *data) {
    char temp_filename[256];
    snprintf(temp_filename, sizeof(temp_filename), "%s.tmp", filename);

    FILE *temp_file = fopen(temp_filename, "w");
    if (!temp_file) {
        return -1;
    }

    if (fwrite(data, sizeof(char), strlen(data), temp_file) < strlen(data)) {
        fclose(temp_file);
        unlink(temp_filename);
        return -1;
    }

    fclose(temp_file);

    if (rename(temp_filename, filename) != 0) {
        unlink(temp_filename);
        return -1;
    }

    return 0;
}

int main() {
    const char *filename = "example.txt";
    const char *data = "This is some important data.";

    if (atomic_write(filename, data) != 0) {
        fprintf(stderr, "Failed to write data atomically\n");
        return EXIT_FAILURE;
    }

    printf("Data written successfully\n");
    return EXIT_SUCCESS;
}