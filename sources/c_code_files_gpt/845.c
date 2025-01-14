#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/wait.h> // Added for wait() function

int main() {
    pid_t pid = fork();

    if (pid < 0) {
        perror("fork failed");
        exit(1);
    } else if (pid == 0) {
        // Child process
        printf("Child process started with PID %d\n", getpid());
        while (1) {
            // Simulate work by sleeping
            sleep(1);
            printf("Child process working...\n");
        }
    } else {
        // Parent process
        printf("Parent process with PID %d, child PID %d\n", getpid(), pid);
        
        // Stop the child process after 3 seconds
        sleep(3);
        printf("Stopping child process...\n");
        kill(pid, SIGSTOP);

        // Sleep for 5 seconds
        sleep(5);

        // Resume the child process
        printf("Resuming child process...\n");
        kill(pid, SIGCONT);

        // Wait for the child process to finish (optional)
        wait(NULL);
    }

    return 0;
}