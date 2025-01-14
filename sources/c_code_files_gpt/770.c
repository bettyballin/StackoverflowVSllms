#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *fp;
    char path[1035];

    // Open the command for reading
    fp = popen("php /var/www/html/phpinfo.php", "r");
    if (fp == NULL) {
        // It's generally good practice to include the error message from the system
        perror("Failed to run command");
        exit(EXIT_FAILURE); // Using EXIT_FAILURE from stdlib.h for portability
    }

    // Read the output a line at a time - output it
    while (fgets(path, sizeof(path), fp) != NULL) {
        printf("%s", path);
    }

    // Close the file pointer and check for errors
    int status = pclose(fp);
    if (status == -1) {
        perror("Error closing the file pointer");
        exit(EXIT_FAILURE);
    } else if (status != 0) {
        printf("The command exited with status %d\n", status);
    }

    return 0;
}