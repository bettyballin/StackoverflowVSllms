#include <stdio.h>
#include <unistd.h>

int main() {
    pid_t pid = fork();

    if (pid == 0) {
        // Child process
        printf("this is child\n");
        execlp("/bin/ls", "ls", NULL);
    } else if (pid > 0) {
        // Parent process
        wait(NULL);
    } else {
        // Error
        perror("fork");
        return 1;
    }

    return 0;
}