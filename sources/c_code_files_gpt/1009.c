#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/wait.h>

int main(int argc, char *argv[]) {
    if (argc < 2) {
        fprintf(stderr, "Usage: %s cmd1 cmd2 ... cmdN\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    int fd[2], i, aux_fd, std0, std1;

    std0 = dup(0); // backup stdin
    std1 = dup(1); // backup stdout

    for (i = 1; i < argc; i++) {
        if (i > 1) {
            dup2(aux_fd, 0);
            close(aux_fd);
        }

        if (i < argc - 1) {
            if (pipe(fd) == -1) {
                perror("pipe");
                exit(EXIT_FAILURE);
            }
            aux_fd = fd[0];
            dup2(fd[1], 1);
            close(fd[1]);
        } else {
            dup2(std1, 1);
            close(std1);
        }

        if (fork() == 0) { // Child process
            if (i < argc - 1) {
                close(fd[0]);
            }
            execlp(argv[i], argv[i], (char *)NULL);
            perror("execlp");
            exit(EXIT_FAILURE);
        }

        if (i < argc - 1) {
            close(fd[1]);
        }
    }

    for (i = 1; i < argc; i++) {
        wait(NULL); // Wait for each child
    }

    // Restore stdin and stdout to keep using the shell
    dup2(std0, 0);
    close(std0);
    // Do not duplicate std1 again, it has been duplicated before.
    close(std1);

    return 0;
}