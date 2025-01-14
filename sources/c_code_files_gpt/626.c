#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    pid_t pid;

    // Fork a new process
    pid = fork();

    if (pid < 0) {
        // Fork failed
        fprintf(stderr, "Fork Failed\n");
        return 1;
    }
    else if (pid == 0) {
        // Child process
        execlp("/bin/ls", "ls", NULL);
    }
    else {
        // Parent process
        // Wait for the child to complete
        wait(NULL);
        printf("Child Complete\n");
    }

    return 0;
}