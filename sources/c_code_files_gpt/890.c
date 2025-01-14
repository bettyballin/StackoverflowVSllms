#include <stdio.h>

// Define the SUCCESS constant
#define SUCCESS 0

// Function prototype for perform_operation
int perform_operation(void);

// Function prototype for log_error
void log_error(const char *message, int error_code);

int main() {
    int result = perform_operation();
    if (result != SUCCESS) {
        log_error("Operation failed", result);
        // Take corrective action or fail gracefully
    }
    return 0;
}

// Define the perform_operation function
int perform_operation(void) {
    // Replace this with your actual operation
    return SUCCESS; // or return a non-zero value to simulate failure
}

// Define the log_error function
void log_error(const char *message, int error_code) {
    printf("Error: %s (Code: %d)\n", message, error_code);
}