#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main() {
    FILE *cgiOut = stdout; // Assuming cgiOut is stdout for this example

    // Write to the stream
    fprintf(cgiOut, "This is some output.\n");

    // Flush the output buffer to ensure all data is written before forking
    fflush(cgiOut);

    pid_t pid = fork();

    if (pid < 0) {
        perror("fork failed");
        exit(EXIT_FAILURE);
    } else if (pid == 0) {
        // Child process
        // Perform background task here
        printf("This is the child process.\n");
        // Exit the child process to prevent it from continuing to execute the parent's code
        _exit(EXIT_SUCCESS);
    } else {
        // Parent process
        printf("This is the parent process.\n");
    }

    return 0;
}