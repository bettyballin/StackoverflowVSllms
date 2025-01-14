#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <sys/wait.h> // Include wait.h for wait function

void handle_signal(int signal) {
    printf("Received signal %d\n", signal); // Added newline character
}

int main() {
    // Set up signal handler
    struct sigaction sa;
    sa.sa_handler = handle_signal;
    sigemptyset(&sa.sa_mask);
    sa.sa_flags = 0;

    if (sigaction(SIGINT, &sa, NULL) == -1) {
        perror("sigaction");
        exit(EXIT_FAILURE);
    }

    // Fork the process
    pid_t pid = fork();

    if (pid == -1) {
        perror("fork");
        exit(EXIT_FAILURE);
    } else if (pid == 0) {
        // Child process
        printf("Child process\n"); // Added newline character
        // The child process inherits the signal handler
        pause();  // Wait for signals
    } else {
        // Parent process
        printf("Parent process\n"); // Added newline character
        // The parent process can send a signal
        kill(pid, SIGINT);
        wait(NULL);
    }

    return 0;
}