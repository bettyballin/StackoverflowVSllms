#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <signal.h>

#define SMALL_SIZE 10000
#define BIG_SIZE 1000000000
#define SIZE BIG_SIZE
#define REPEATS 1

void signal_handler(int signum) {
    // Use a safer alternative to printf in signal handlers
    char message[256];
    sprintf(message, "Process %d received signal %d\n", getpid(), signum);
    write(STDERR_FILENO, message, strlen(message));
    exit(EXIT_FAILURE);
}

int child_process() {
    signal(SIGTERM, signal_handler);

    pid_t my_pid = getpid();
    char *x = malloc(SIZE * sizeof(char));

    if (x == NULL) {
        printf("Malloc failed!\n");
        return EXIT_FAILURE;
    }

    for (int x2 = 0; x2 < REPEATS; ++x2) {
        for (int y = 0; y < SIZE; ++y) {
            x[y] = (y + my_pid) % 256;
        }
    }

    printf("%d: I'm over.\n", my_pid);
    free(x);
    return EXIT_SUCCESS;
}

int fork_and_wait() {
    pid_t pid = fork();
    if (pid == 0) {
        // Child process
        exit(child_process());
    } else if (pid > 0) {
        // Parent process
        int status;
        waitpid(pid, &status, 0);
        if (WIFEXITED(status)) {
            printf("Child %d exited with status %d\n", pid, WEXITSTATUS(status));
        } else if (WIFSIGNALED(status)) {
            printf("Child %d killed by signal %d\n", pid, WTERMSIG(status));
        }
    } else {
        // Fork failed
        perror("fork");
        return EXIT_FAILURE;
    }
    return EXIT_SUCCESS;
}

int main() {
    for (int i = 0; i < 5; i++) {
        fork_and_wait();
    }
    return 0;
}