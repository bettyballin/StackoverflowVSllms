#include <stdio.h>\n#include <stdlib.h>\n#include <string.h>\n#include <unistd.h>\n#include <wait.h>\n#include <signal.h>\n#include <sys/types.h>\n\ntypedef enum { FALSE, TRUE } bool;\n\nvoid childSignalHandler(int signum) {\n    int status;\n    pid_t pid;\n    \n    // Loop to handle all zombie processes\n    while ((pid = waitpid(-1, &status, WNOHANG)) > 0) {\n        if (WIFEXITED(status)) {\n            printf("Background process %d exited with status %d\n", pid, WEXITSTATUS(status));\n        } else if (WIFSIGNALED(status)) {\n            printf("Background process %d terminated by signal %d\n", pid, WTERMSIG(status));\n        }\n    }\n}\n\nint main(int argc, char **argv) {\n    char bBuffer[BUFSIZ], *pArgs[10], *aPtr = NULL, *sPtr;\n    bool background;\n    ssize_t rBytes;\n    int aCount;\n    pid_t pid;\n\n    signal(SIGCHLD, childSignalHandler);\n\n    while (1) {\n        write(1, "\e[1;31mmyBash \e[1;32m# \e[0m", 27);\n        rBytes = read(0, bBuffer, BUFSIZ-1);\n\n        if(rBytes == -1) {\n            perror("read");\n            exit(1);\n        }\n\n        bBuffer[rBytes-1] = '\0';\n\n        if(!strcasecmp(bBuffer, "exit")) {\n            exit(0);\n        }\n\n        sPtr = bBuffer;\n        aCount = 0;\n\n        do {\n            aPtr = strsep(&sPtr, " ");\n            pArgs[aCount++] = aPtr;\n        } while(aPtr);\n\n        background = FALSE;\n\n        if (aCount > 1 && !strcmp(pArgs[aCount-2], "&")) {\n            pArgs[aCount-2] = NULL;\n            background = TRUE;\n        }\n\n        if(strlen(pArgs[0]) > 1) {\n            pid = fork();\n\n            if(pid == -1) {\n                perror("fork");\n                exit(1);\n            }\n\n            if(pid == 0) {\n                execvp(pArgs[0], pArgs);\n                perror("execvp"); // Print error if execvp fails\n                exit(EXIT_FAILURE); // Exit with failure status\n            }\n\n            if(!background) {\n                wait(NULL); // Wait for foreground process\n            } else {\n                printf("Background process started with PID: %d\n", pid);\n            }\n        }\n    }\n\n    return 0;\n}