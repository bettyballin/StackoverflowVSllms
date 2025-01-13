#include <stdio.h>\n#include <stdlib.h>\n#include <sys/types.h>\n#include <sys/wait.h>\n#include <unistd.h>\n\nint main() {\n    pid_t pids[5];\n    int i;\n\n    // Spawn 5 child processes\n    for (i = 0; i < 5; i++) {\n        pids[i] = fork();\n        if (pids[i] < 0) {\n            fprintf(stderr, "Fork failed\n");\n            exit(1);\n        } else if (pids[i] == 0) {\n            // Child process\n            char * x = malloc(BIG_SIZE*sizeof(char));\n            if (x == NULL) {\n                printf("Malloc failed!");\n                return(EXIT_FAILURE);\n            }\n            int x2=0;\n            for(x2=0;x2<REAPETS;++x2){\n                int y;\n                for(y=0;y<BIG_SIZE;++y)\n                    x[y] = (y+getpid())%256;\n            }\n            printf("%d: I'm over.\n", getpid());\n            return(EXIT_SUCCESS);\n        }\n    }\n\n    // Parent process waits for each child to terminate\n    int status;\n    pid_t pid;\n    while ((pid = wait(&status)) > 0) {\n        if (WIFEXITED(status)) {\n            printf("Child with PID %d exited normally with exit code %d\n", pid, WEXITSTATUS(status));\n        } else if (WIFSIGNALED(status)) {\n            printf("Child with PID %d was killed by signal %d\n", pid, WTERMSIG(status));\n        }\n    }\n\n    return 0;\n}