#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main() {
    pid_t pid;

    pid = fork();

    if (pid == 0) {
        /* child */
        printf("This is the child process\n");
    } else if (pid > 0) {
        /* parent */
        printf("This is the parent process\n");
    } else {
        /* error */
        perror("fork");
        return 1;
    }

    return 0;
}