#include <stdio.h>\n#include <stdlib.h>\n#include <unistd.h>\n#include <sys/types.h>\n#include <sys/ipc.h>\n#include <sys/shm.h>\n#include <sys/wait.h>\n#include <fcntl.h>  // For O_* constants\n#include <sys/stat.h> // For mode constants\n\n// Assume all the variables have been declared previously and the required headers are included\n// int x1, x2, n, segment_id;\n// double size;\n// char *shared_memory;\n// double f(double x); // Assume this function is defined somewhere\n\nint main() {\n    pid_t pid;\n\n    // create 5 child processes\n    for (int k = 0; k < 5; k++) {\n        // fork a child process\n        pid = fork();\n\n        // error occurred on fork\n        if (pid < 0) {\n            fprintf(stderr, "Fork Failed");\n            return 1;\n        }\n        // this is what the child process will run\n        else if (pid == 0) {\n            // create a shared memory segment\n            segment_id = shmget(IPC_PRIVATE, size, S_IRUSR | S_IWUSR);\n\n            // attach the shared memory segment\n            shared_memory = (char *)shmat(segment_id, NULL, 0);\n\n            printf("this is child\n");\n\n            double x = 0;\n            double sum = 0;\n\n            // Run process that sums the function\n            for (int i = 0; i < n; i++) {\n                // get random number in range of x1-x2\n                x = rand() % (x2 - x1 + 1) + x1;\n                sum = sum + f(x);\n            }\n\n            // write output to the shared memory segment\n            sprintf(shared_memory, "%f", sum);\n\n            // Replacing the process image with `/bin/ls`\n            execlp("/bin/ls", "ls", NULL);\n\n            // If execlp fails\n            fprintf(stderr, "execlp failed\n");\n            exit(1);\n        }\n        // this is what the parent process will run\n        else {\n            // wait for the child process to complete\n            wait(NULL);\n\n            // attach the shared memory segment\n            shared_memory = (char *)shmat(segment_id, NULL, 0);\n\n            // print output from shared memory\n            printf("\n*%s", shared_memory);\n\n            // detach shared memory\n            shmdt(shared_memory);\n\n            // remove the shared memory segment\n            shmctl(segment_id, IPC_RMID, NULL);\n        }\n    } // End of for statement\n\n    return 0;\n}