#include <stdio.h>\n#include <stdlib.h>\n#include <unistd.h>\n\nint main() {\n    // Create a new process using fork()\n    pid_t pid = fork();\n\n    if (pid == 0) {\n        // Child process\n        printf("Hello from child process!\n");\n        exit(0);\n    } else {\n        // Parent process\n        printf("Hello from parent process!\n");\n        wait(NULL); // Wait for child process to finish\n    }\n\n    return 0;\n}