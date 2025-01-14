#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <sys/wait.h>

void handle_signal(int sig) {
    killpg(getpgrp(), SIGKILL);
}

int main() {
    pid_t pid = fork();

    if (pid == -1) {
        perror("fork failed");
        exit(EXIT_FAILURE);
    }

    if (pid == 0) {
        // Child process
        while (1) {
            printf("Child process running\n");
            sleep(1);
        }
    } else {
        // Parent process
        signal(SIGTERM, handle_signal);

        // Simulate parent work
        sleep(10);
        
        // Send termination signal to the parent process
        kill(getpid(), SIGTERM);
        
        // Ensure clean exit
        wait(NULL);
        printf("Parent process exiting\n");
    }

    return 0;
}