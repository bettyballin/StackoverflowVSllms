#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <errno.h>

int execute_command(const char *cmd, char *output, size_t output_size) {
    int pipefd[2];
    pid_t pid;
    int status;

    if (pipe(pipefd) == -1) {
        perror("pipe");
        return -1;
    }

    if ((pid = fork()) == -1) {
        perror("fork");
        return -1;
    }

    if (pid == 0) {  // Child process
        close(pipefd[0]);  // Close read end
        dup2(pipefd[1], STDOUT_FILENO);  // Redirect stdout to pipe
        dup2(pipefd[1], STDERR_FILENO);  // Redirect stderr to pipe
        close(pipefd[1]);

        execl("/bin/sh", "sh", "-c", cmd, (char *)NULL);
        perror("execl");
        _exit(EXIT_FAILURE);
    } else {  // Parent process
        close(pipefd[1]);  // Close write end

        ssize_t bytes_read = read(pipefd[0], output, output_size - 1);
        if (bytes_read >= 0) {
            output[bytes_read] = '\0';  // Null-terminate the output
        } else {
            perror("read");
            close(pipefd[0]);
            return -1;
        }
        close(pipefd[0]);

        if (waitpid(pid, &status, 0) == -1) {
            perror("waitpid");
            return -1;
        }

        if (WIFEXITED(status)) {
            return WEXITSTATUS(status);
        } else {
            return -1;
        }
    }
}

int main() {
    char output[1024];
    int ret = execute_command("ls -l", output, sizeof(output));
    if (ret != -1) {
        printf("Command output:\n%s\n", output);
        printf("Command exited with status: %d\n", ret);
    } else {
        printf("Failed to execute command\n");
    }
    return 0;
}