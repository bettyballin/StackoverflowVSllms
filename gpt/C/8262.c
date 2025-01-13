#include <stdio.h>\n#include <stdlib.h>\n#include <unistd.h>\n#include <sys/types.h>\n#include <sys/wait.h>\n\nint main() {\n    int pipefd[2];\n    pid_t pid;\n    char buffer[1024];\n    ssize_t count;\n\n    if (pipe(pipefd) == -1) {\n        perror("pipe failed");\n        exit(EXIT_FAILURE);\n    }\n\n    pid = fork();\n    if (pid == -1) {\n        perror("fork failed");\n        exit(EXIT_FAILURE);\n    }\n\n    if (pid == 0) {  // Child process\n        close(pipefd[0]);  // Close unused read end\n        dup2(pipefd[1], STDOUT_FILENO);  // Redirect stdout to pipe\n        close(pipefd[1]);  // Close write end after duplicating\n\n        execl("/bin/ls", "ls", "-l", (char *)0);\n        perror("execl failed");  // execl only returns on failure\n        exit(EXIT_FAILURE);\n    } else {  // Parent process\n        close(pipefd[1]);  // Close unused write end\n        while ((count = read(pipefd[0], buffer, sizeof(buffer) - 1)) > 0) {\n            buffer[count] = '\0';\n            printf("%s", buffer);\n        }\n        close(pipefd[0]);\n        wait(NULL);  // Wait for child process to finish\n    }\n\n    return 0;\n}