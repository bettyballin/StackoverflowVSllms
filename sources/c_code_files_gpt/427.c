#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>
#include <readline/readline.h>
#include <readline/history.h>

#define NUMPIPES 2

int main(int argc, char *argv[]) {
    char *bBuffer, *sPtr, *aPtr, *pipeComms[NUMPIPES + 1], *cmdArgs[10];
    int fdPipe[NUMPIPES][2], pCount, aCount, i, status, lPids[NUMPIPES + 1];
    pid_t pid;

    while(1) {
        bBuffer = readline("Shell> ");
        if (!bBuffer) continue;

        if (!strcasecmp(bBuffer, "exit")) {
            free(bBuffer);
            return 0;
        }

        sPtr = bBuffer;
        pCount = -1;

        do {
            aPtr = strsep(&sPtr, "|");
            pipeComms[++pCount] = aPtr;
        } while (aPtr);

        for (i = 0; i < pCount; i++) {
            if (i < pCount - 1) {
                if (pipe(fdPipe[i]) == -1) {
                    perror("pipe");
                    exit(1);
                }
            }

            aCount = -1;
            do {
                aPtr = strsep(&pipeComms[i], " ");
                cmdArgs[++aCount] = aPtr;
            } while (aPtr);
            cmdArgs[aCount] = 0;

            if (strlen(cmdArgs[0]) > 0) {
                pid = fork();

                if (pid == 0) { // Child process
                    if (i > 0) {
                        dup2(fdPipe[i-1][0], STDIN_FILENO);
                        close(fdPipe[i-1][0]);
                        close(fdPipe[i-1][1]);
                    }

                    if (i < pCount - 1) {
                        close(fdPipe[i][0]);
                        dup2(fdPipe[i][1], STDOUT_FILENO);
                        close(fdPipe[i][1]);
                    }

                    execvp(cmdArgs[0], cmdArgs);
                    perror("execvp");
                    exit(1);
                } else if (pid > 0) { // Parent process
                    lPids[i] = pid;
                    if (i > 0) {
                        close(fdPipe[i-1][0]);
                        close(fdPipe[i-1][1]);
                    }
                } else {
                    perror("fork");
                    exit(1);
                }
            }
        }

        free(bBuffer);

        for (i = 0; i < pCount; i++) {
            waitpid(lPids[i], &status, 0);
            if (WIFEXITED(status)) {
                printf("[%d] TERMINATED (Status: %d)\n", lPids[i], WEXITSTATUS(status));
            }
        }
    }

    return 0;
}