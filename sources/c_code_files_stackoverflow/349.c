#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main() {
    pid_t pid;

    switch (pid = fork()) {
    case -1:       /* Failure */
        perror("fork");
        exit(EXIT_FAILURE);
    case 0:        /* Child */
        printf("Child process (PID: %d)\n", getpid());
        break;
    default:       /* Parent */
        printf("Parent process (PID: %d)\n", getpid());
        break;
    }

    return 0;
}