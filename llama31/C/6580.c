#include <stdio.h>\n#include <stdlib.h>\n#include <fcntl.h>\n#include <unistd.h>\n#include <sys/types.h>\n#include <sys/wait.h>\n\nint main(int argc, char *argv[]) {\n    int fd[2], i, aux, std0, std1;\n    pid_t pid;\n\n    // Backup stdin and stdout\n    std0 = dup(0);\n    if (std0 == -1) {\n        perror("dup");\n        exit(EXIT_FAILURE);\n    }\n\n    std1 = dup(1);\n    if (std1 == -1) {\n        perror("dup");\n        exit(EXIT_FAILURE);\n    }\n\n    for (i = 1; i < argc; i++) {\n        // Do we have a previous command?\n        if (i > 1) {\n            dup2(aux, 0);\n            close(aux);\n        }\n\n        // Do we have a next command?\n        if (i < argc - 1) {\n            if (pipe(fd) == -1) {\n                perror("pipe");\n                exit(EXIT_FAILURE);\n            }\n\n            aux = fd[0];\n            dup2(fd[1], 1);\n            close(fd[1]);\n        }\n\n        // Last command? Restore stdout...\n        if (i == argc - 1) {\n            dup2(std1, 1);\n            close(std1);\n        }\n\n        pid = fork();\n        if (pid == -1) {\n            perror("fork");\n            exit(EXIT_FAILURE);\n        }\n\n        if (pid == 0) {\n            // If not last command, close all pipe ends\n            // (the child doesn't use them)\n            if (i < argc - 1) {\n                close(std0);\n                close(std1);\n                close(fd[0]);\n            }\n\n            execlp(argv[i], argv[i], NULL);\n            perror("execlp");\n            exit(EXIT_FAILURE);\n        }\n    }\n\n    // Restore stdin to be able to keep using the shell\n    dup2(std0, 0);\n    close(std0);\n\n    // Wait for all child processes to finish\n    while (wait(NULL) != -1);\n\n    return 0;\n}