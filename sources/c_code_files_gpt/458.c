#include <stdio.h>

void exampleFunction() {
    int error_condition = 1; // Simulating an error condition for demonstration

    if (error_condition) {
        goto ERROR_HANDLER;
    }

    // This will be skipped if error_condition is true
    printf("No error encountered.\n");

    return; // This is here to avoid falling into the error handler if no error

ERROR_HANDLER:
    // Handle error
    printf("Error encountered. Handling it...\n");
    return;
}

int main() {
    exampleFunction();
    return 0;
}