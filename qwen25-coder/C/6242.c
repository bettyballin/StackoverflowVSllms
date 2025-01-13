#include <stdio.h>\n#include <sys/types.h>\n#include <unistd.h>\n\n#define MAX_CHILDREN 5\n\nint main() {\n    pid_t child_pid;\n    int level = 0;\n\n    printf("parent (%d)\n", getpid());\n\n    for (level = 1; level <= MAX_CHILDREN; ++level) {\n        if ((child_pid = fork()) == 0) { // Child process\n            if (level % 2 == 0) { // Even level, create two more children\n                printf("  |\n  +---> child (%d)\n", getpid());\n                for (int i = 1; i <= 2; ++i) {\n                    pid_t grandchild_pid;\n                    if ((grandchild_pid = fork()) == 0) { // Grandchild process\n                        printf("          |\n          +----> child (%d)\n", getpid());\n                    } else if (grandchild_pid > 0) {\n                        waitpid(grandchild_pid, NULL, 0); // Wait for grandchild to finish\n                    }\n                }\n            } else { // Odd level, only print the current process\n                printf("  |\n  +---> child (%d)\n", getpid());\n            }\n            return 0; // Child process exits after creating its children (if necessary)\n        } else if (child_pid > 0) {\n            waitpid(child_pid, NULL, 0); // Parent waits for the current child\n            break; // Only one child per level from parent\n        }\n    }\n\n    return 0;\n}