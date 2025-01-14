#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

int main() {
    pid_t p = fork();
    if (p == -1) {
        // Handle fork error
        perror("fork failed");
        exit(EXIT_FAILURE);
    } else if (p == 0) {
        // Child process
        /* do child stuff */
    } else {
        // Parent process
        /* do parent stuff */
    }
    return 0;
}