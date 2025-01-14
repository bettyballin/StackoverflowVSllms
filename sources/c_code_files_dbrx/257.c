#include <stdarg.h>
#include <stdio.h>

void print_and_write(FILE *file_p, char* fmt, ...) {
    va_list args;
    va_start (args, fmt);

    // Print on screen using stdout as file pointer and given format string
    vprintf (fmt, args);

    // Write to file using given file pointer
    vfprintf(file_p, fmt, args);

    va_end (args);
}

int main() {
    FILE *file_p = fopen("output.txt", "w");
    if (file_p == NULL) {
        perror("Error opening file");
        return 1;
    }

    print_and_write(file_p, "Hello, world!\n");
    fclose(file_p);
    return 0;
}