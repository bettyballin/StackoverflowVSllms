#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    int i = 1; // assuming i is an index
    int num_commands = 3; // assuming num_commands is the number of commands
    int fdPipe[2];
    int new_pipe[2];

    // Create pipes
    if (pipe(fdPipe) == -1) {
        perror("pipe");
        exit(EXIT_FAILURE);
    }

    if (pipe(new_pipe) == -1) {
        perror("pipe");
        exit(EXIT_FAILURE);
    }

    if (i < num_commands - 1) { // All commands except last command in pipeline
        dup2(fdPipe[1], STDOUT_FILENO);   // Make stdout go to the write-end of pipe
        close(fdPipe[0]);                 // Close unused end of pipe
    } else if (i > 0) {                    // The last command in our pipeline
        dup2(new_pipe[0], STDIN_FILENO);   // Make stdin go to the read-end of new pipe made from dup()
        close(fdPipe[1]);                  // Close unused end of old pipe
    }

    return 0;
}