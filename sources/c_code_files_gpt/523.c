#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *dump_f = fopen("dump.txt", "w");
    if (dump_f == NULL) {
        perror("Failed to open file");
        return EXIT_FAILURE;
    }
    // Additional code to actually use the file goes here
    // For example, writing to the file and then closing it
    fprintf(dump_f, "Test line written to dump.txt\n");
    fclose(dump_f);
    return EXIT_SUCCESS;
}