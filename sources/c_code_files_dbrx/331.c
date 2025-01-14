#include <stdio.h>
#include <stdlib.h>

// Define a structure for serial information
typedef struct {
    long start_int_idx;
    int current_int_idx;
} serial_info_t;

// Function to print and write to a file
void print_and_write(FILE *file, const char *format, ...) {
    va_list args;
    va_start(args, format);
    vfprintf(stdout, format, args); // Print to stdout
    va_end(args);
    va_start(args, format);
    vfprintf(file, format, args); // Write to file
    va_end(args);
}

int main() {
    // Create a sample serial_info structure
    serial_info_t serial_info = {1234567890L, 100};

    // Open a file for writing
    FILE *file_p = fopen("serial_info.txt", "w");
    if (!file_p) {
        fprintf(stderr, "Failed to open file for writing.\n");
        return EXIT_FAILURE;
    }

    // Call the print_and_write function
    serial_info_t *serial_info_p = &serial_info;
    print_and_write(stdout, "Starting serial number        [%ld]\n", serial_info_p->start_int_idx);
    print_and_write(file_p, "Current Serial number          [%d]\n", serial_info_p->current_int_idx);

    // Close the file
    fclose(file_p);

    return EXIT_SUCCESS;
}