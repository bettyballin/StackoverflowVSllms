#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <sys/wait.h>

void sigchld_handler(int signo) {
    int status;
    pid_t pid;

    // Reap all dead child processes
    while ((pid = waitpid(-1, &status, WNOHANG)) > 0) {
        printf("Reaped child process with PID %d\n", pid);
    }
}

int main() {
    struct sigaction sa;
    sa.sa_handler = sigchld_handler;
    sigemptyset(&sa.sa_mask);
    sa.sa_flags = SA_RESTART;

    if (sigaction(SIGCHLD, &sa, NULL) == -1) {
        perror("sigaction");
        exit(EXIT_FAILURE);
    }

    // Your code to fork and run ssh commands in the background
    // For demonstration purposes, we'll just fork and run a simple command
    pid_t pid = fork();
    if (pid == 0) {
        // Child process
        execl("/bin/sh", "sh", "-c", "sleep 5", (char *) NULL);
    } else if (pid == -1) {
        perror("fork");
        exit(EXIT_FAILURE);
    }

    // Prevent the main process from exiting
    while (1) {
        pause();
    }

    return 0;
}