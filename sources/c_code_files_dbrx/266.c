#include <unistd.h>
#include <sys/wait.h>
#include <stdio.h>  // Added for perror
#include <stdlib.h> // Added for exit
#include <sys/types.h> // Added for pid_t

void run(const char *cmd) {
    pid_t child = fork();
    if (child == 0) { // Child process
        if (setuid(65534) != 0) { // nobody id
            perror("setuid");
            exit(EXIT_FAILURE);
        }
        execl("/bin/sh", "sh", "-c", cmd, (char*) NULL);
        // If execl returns, it's an error
        perror("execl");
        exit(EXIT_FAILURE);
    } else if (child > 0) { // Parent process
        int status;
        // Wait for child to finish
        if (waitpid(child, &status, 0) == -1) {
            perror("waitpid");
            exit(EXIT_FAILURE);
        }
    } else { // Fork error handling
        perror("fork");
        exit(EXIT_FAILURE);
    }
}

int main() {
    run("echo 'Hello, World!'");
    return 0;
}