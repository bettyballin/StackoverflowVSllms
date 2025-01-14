#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <stdio.h> // Added for perror

void reload() {
    pid_t pid = fork();

    if (pid == -1) {
        // Fork failed
        perror("fork");
        exit(EXIT_FAILURE);
    } else if (pid == 0) {
        // Child process
        execl("/etc/init.d/foo", "foo", "restart", (char *)NULL);
        // If execl returns, it must have failed
        perror("execl");
        exit(EXIT_FAILURE);
    } else {
        // Parent process
        // Optionally wait for the child process to finish
        int status;
        waitpid(pid, &status, 0);
    }
}

int main() {
    reload();
    return 0;
}