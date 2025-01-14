#include <stdio.h> // Include the standard input/output header file

#define BUFFER_SIZE 100

int main() {
    char buff[BUFFER_SIZE];
    
    // It's highly recommended to avoid using gets() due to security risks.
    // gets(buff); // unsafe!

    fgets(buff, sizeof(buff), stdin); // safe

    // Optionally, print the input to verify it was read correctly
    printf("You entered: %s", buff);

    return 0; // Successful execution
}