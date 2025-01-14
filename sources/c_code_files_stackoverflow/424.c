#include <stdio.h>
#include <string.h>
#include <ini.h>

int main() {
    // Create a new INI file object
    inih_t *ini = inih_new();

    // Set a value in the INI file
    inih_put(ini, "mysection", "mykey", "myvalue");

    // Open the INI file for writing
    FILE *file = fopen("myinifile.ini", "w");
    if (!file) {
        printf("Failed to open file for writing.\n");
        return 1;
    }

    // Write the INI file to disk
    inih_write(ini, file);

    // Close the file
    fclose(file);

    // Free the INI file object
    inih_free(ini);

    return 0;
}