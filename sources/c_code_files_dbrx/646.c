#include <stdio.h>
#include <sys/types.h>
#include <signal.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdbool.h>

// Define a boolean variable to track background execution
bool background = false;

void childSignalHandler(int signum) {
    // Reap any zombie processes, this will also prevent the SIGCHLD signal from being called continuously.
    while (waitpid(-1, NULL, WNOHANG) > 0);
}

int main() {
    // Example: Fork a new process
    pid_t pid = fork();

    if (pid < 0) {
        // Error occurred
        perror("fork");
        return 1;
    }

    if (pid == 0) {
        // Child process
        printf("Child process is executing...\n");
        // Simulate some work
        sleep(2);
        printf("Child process finished.\n");
        return 0;
    }

    // Parent process
    if (!background) {
        wait(NULL); // Or you can use waitpid here to block only on the child process that was just forked.
    } else {
        signal(SIGCHLD, childSignalHandler); // Setup a handler for SIGCHLD signals from background processes
        printf("Parent process continuing in background...\n");
    }

    printf("Parent process finished.\n");
    return 0;
}