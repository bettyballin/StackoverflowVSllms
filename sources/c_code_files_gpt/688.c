#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <errno.h>

int main() {
    char *pArgs[] = {"ls", "-l", NULL}; // Define pArgs

    pid_t pid = fork();

    if (pid == -1) {
        perror("fork");
        exit(1);
    }

    if (pid == 0) {
        // CHILD PROCESS CODE GOES HERE...
        execvp(pArgs[0], pArgs);
        // If execvp() returns, it means there was an error
        perror("execvp");
        exit(1); // Exit with an error code
    } else {
        // PARENT PROCESS CODE GOES HERE...
        int status;
        waitpid(pid, &status, 0); // Wait for the child process to finish

        if (WIFEXITED(status)) {
            int exit_status = WEXITSTATUS(status);
            printf("Child exited with status: %d\n", exit_status);
        } else if (WIFSIGNALED(status)) {
            int signal_number = WTERMSIG(status);
            printf("Child terminated by signal: %d\n", signal_number);
        }
    }

    return 0;
}