// license_check.c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Function to simulate license key validation
int validate_license(const char* key) {
    const char* valid_key = "VALID_LICENSE_KEY";
    if (strcmp(key, valid_key) == 0) {
        return 1; // License is valid
    }
    return 0; // License is invalid
}

void critical_function() {
    printf("Performing critical operation...\n");
}

int main() {
    const char* license_key = "VALID_LICENSE_KEY";
    if (validate_license(license_key)) {
        critical_function();
    } else {
        printf("Invalid license key. Exiting...\n");
        return 1;
    }
    return 0;
}