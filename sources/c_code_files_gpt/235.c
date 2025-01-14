#include <stdio.h>
#include <stdarg.h> // Added for va_list, va_start, va_end

void print_and_write(FILE *file_p, const char *format, ...) {
    va_list args;

    // Print to screen
    va_start(args, format);
    vprintf(format, args);
    va_end(args);

    // Write to file
    va_start(args, format);
    vfprintf(file_p, format, args);
    va_end(args);
}

int main() {
    FILE *file_p = fopen("output.txt", "w");
    if (file_p == NULL) {
        perror("Error opening file");
        return 1;
    }

    // Example structure
    struct {
        long start_int_idx;
        int current_int_idx;
    } serial_info = {1234567890, 42};

    print_and_write(file_p, "Starting serial number       [%ld]\n", serial_info.start_int_idx);
    print_and_write(file_p, "Current Serial number         [%d]\n", serial_info.current_int_idx);

    fclose(file_p);
    return 0;
}