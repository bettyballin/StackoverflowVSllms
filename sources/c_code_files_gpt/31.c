#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main() {
    int fd[2];
    pid_t pid;
    char write_msg[] = "Hello";
    char read_msg[10];

    // Create the pipe
    if (pipe(fd) == -1) {
        perror("pipe");
        exit(EXIT_FAILURE);
    }

    // Fork a child process
    pid = fork();
    if (pid < 0) {
        perror("fork");
        exit(EXIT_FAILURE);
    }

    if (pid > 0) { // Parent process
        close(fd[0]); // Close unused read end
        write(fd[1], write_msg, sizeof(write_msg));
        close(fd[1]); // Close write end after writing
    } else { // Child process
        close(fd[1]); // Close unused write end
        read(fd[0], read_msg, sizeof(write_msg));
        printf("Received message: %s\n", read_msg);
        close(fd[0]); // Close read end after reading
    }

    return 0;
}