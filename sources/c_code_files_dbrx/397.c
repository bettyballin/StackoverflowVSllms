#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    pid_t pid;
    int status;

    // Create a child process
    pid = fork();

    if (pid < 0) {
        // Error handling
        perror("fork");
        exit(1);
    }

    if (pid == 0) {
        // Child process
        printf("Child process PID: %d\n", getpid());
        sleep(5);
        printf("Child process exiting...\n");
        exit(0);
    }

    // Parent process
    printf("Parent process PID: %d\n", getpid());
    printf("Waiting for child process to finish...\n");
    waitpid(pid, &status, 0);
    printf("Child process finished with status %d\n", WEXITSTATUS(status));

    return 0;
}