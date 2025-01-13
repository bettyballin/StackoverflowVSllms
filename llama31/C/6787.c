#include <stdio.h>\n#include <stdlib.h>\n#include <unistd.h>\n\nint main() {\n    pid_t pid;\n\n    pid = fork();\n    if (pid < 0) {\n        perror("fork");\n        exit(1);\n    }\n\n    if (pid > 0) {\n        // Parent process can exit\n        exit(0);\n    }\n\n    // Child process\n    setsid(); // Become session leader\n\n    // Implement your program logic here\n    while (1) {\n        printf("Daemon process working...\n");\n        sleep(1);\n    }\n\n    return 0;\n}