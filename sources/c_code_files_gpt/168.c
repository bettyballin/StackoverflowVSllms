#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    FILE *file;
    char buffer[256];

    // Check if a file is provided as an argument
    if (argc > 1) {
        file = freopen(argv[1], "r", stdin);
        if (file == NULL) {
            perror("Failed to open file");
            return EXIT_FAILURE;
        }
    }

    // Read from the file (if provided) or stdin
    while (fgets(buffer, sizeof(buffer), stdin) != NULL) {
        printf("Script line: %s", buffer);
    }
    
    // Reset stdin to terminal input
    if (argc > 1) {
        freopen("/dev/tty", "r", stdin);
    }

    // Now you can use scanf to read from terminal input
    printf("Enter a value: ");
    int x;
    scanf("%d", &x);
    printf("You entered: %d\n", x); // Added newline character

    return EXIT_SUCCESS;
}