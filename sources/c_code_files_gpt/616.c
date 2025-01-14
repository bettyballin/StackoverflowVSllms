#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    int pipefd[2];
    pid_t pid;
    char buffer[1024];
    ssize_t count;

    if (pipe(pipefd) == -1) {
        perror("pipe failed");
        exit(EXIT_FAILURE);
    }

    pid = fork();
    if (pid == -1) {
        perror("fork failed");
        exit(EXIT_FAILURE);
    }

    if (pid == 0) {  // Child process
        close(pipefd[0]);  // Close unused read end
        dup2(pipefd[1], STDOUT_FILENO);  // Redirect stdout to pipe
        close(pipefd[1]);  // Close write end after duplicating

        execl("/bin/ls", "ls", "-l", (char *)0);
        perror("execl failed");  // execl only returns on failure
        exit(EXIT_FAILURE);
    } else {  // Parent process
        close(pipefd[1]);  // Close unused write end
        while ((count = read(pipefd[0], buffer, sizeof(buffer) - 1)) > 0) {
            buffer[count] = '\0';
            printf("%s", buffer);
        }
        close(pipefd[0]);
        wait(NULL);  // Wait for child process to finish
    }

    return 0;
}