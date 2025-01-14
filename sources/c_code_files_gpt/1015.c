#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <wait.h>
#include <signal.h>
#include <sys/types.h>

// Boolean typedef and true/false macros
typedef enum { FALSE, TRUE } bool;

void childSignalHandler(int signum) {
    int saved_errno = errno;
    while (waitpid(-1, NULL, WNOHANG) > 0);
    errno = saved_errno;
}

int main(int argc, char **argv) {
    char bBuffer[BUFSIZ], *pArgs[10], *aPtr = NULL, *sPtr;
    bool background;
    ssize_t rBytes;
    int aCount;
    pid_t pid;

    signal(SIGCHLD, childSignalHandler);

    while(1) {
        write(1, "\e[1;31mmyBash \e[1;32m# \e[0m", 27);
        rBytes = read(0, bBuffer, BUFSIZ-1);

        if(rBytes == -1) {
            perror("read");
            exit(1);
        }

        bBuffer[rBytes-1] = '\0';

        if(!strcasecmp(bBuffer, "exit")) {
            exit(0);
        }

        sPtr = bBuffer;
        aCount = 0;

        do {
            aPtr = strsep(&sPtr, " ");
            pArgs[aCount++] = aPtr;
        } while(aPtr);

        background = FALSE;

        if(aCount > 1 && !strcmp(pArgs[aCount-1], "&")) {
            pArgs[aCount-1] = NULL;
            background = TRUE;
        }

        if(aCount > 0 && strlen(pArgs[0]) > 1) {
            pid = fork();

            if(pid == -1) {
                perror("fork");
                exit(1);
            }

            if(pid == 0) {
                execvp(pArgs[0], pArgs);
                perror("execvp"); // In case execvp fails
                exit(1);
            }

            if(!background) {
                waitpid(pid, NULL, 0);
            }
        }
    }

    return 0;
}