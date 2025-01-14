#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define READ 0
#define WRITE 1

int main() {
    int child_fds[1][2]; // Assuming one pipe
    int i = 0; // Index for the child_fds array

    // Create a pipe
    if (pipe(child_fds[i]) == -1) {
        perror("pipe() failed.");
        exit(-1);
    }

    pid_t pid = fork();

    switch(pid) {
        case -1: // Error handling
            perror("fork() failed.");
            exit(-1);

        case 0: { // Child
            close(child_fds[i][READ]); // Close the read end of pipe inside child because it won't use that to communicate back.
            dup2(child_fds[i][WRITE], STDOUT_FILENO); // Make stdout point at write end of this pipe, replacing default file descriptor (STDOUT) with a custom one (write end of the pipe).
            // Example usage: Anything printed to stdout will go through the pipe.
            printf("Hello, parent!\n");
            close(child_fds[i][WRITE]); // Close the write end of the pipe in the child.
            exit(0); // Exit the child process.
        }

        default: { // Parent
            close(child_fds[i][WRITE]); // Close the write end of the pipe in the parent.
            char buffer[100];
            read(child_fds[i][READ], buffer, sizeof(buffer)); // Read from the pipe.
            printf("Received from child: %s\n", buffer);
            close(child_fds[i][READ]); // Close the read end of the pipe.
            wait(NULL); // Wait for the child to finish.
        }
    }

    return 0;
}