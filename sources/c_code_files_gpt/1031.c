#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>  // Added this line

int main() {
    FILE *fp;
    char path[1035];
    int status;

    // Open the command for reading
    fp = popen("ls -l /", "r");
    if (fp == NULL) {
        perror("popen failed");
        exit(EXIT_FAILURE);
    }

    // Read the output a line at a time and print it to stdout
    while (fgets(path, sizeof(path)-1, fp) != NULL) {
        printf("%s", path);
    }

    // Close the pipe and get the exit status
    status = pclose(fp);
    if (status == -1) {
        perror("pclose failed");
        exit(EXIT_FAILURE);
    }

    // Extract and print the exit status
    if (WIFEXITED(status)) {
        printf("Command exited with status %d\n", WEXITSTATUS(status));  // Added newline character
    } else {
        printf("Command did not exit normally\n");  // Added newline character
    }

    return 0;
}