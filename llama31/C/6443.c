#include <stdio.h>\n#include <stdlib.h>\n#include <unistd.h>\n#include <sys/types.h>\n#include <sys/wait.h>\n\n#define NUM_PROCESSES 10\n#define NUM_ELEMENTS 1000000\n#define TARGET_NUMBER 5\n\nvoid childProcess(int row, int matrix[row][NUM_ELEMENTS]) {\n    int count = 0;\n    char filename[32];\n    sprintf(filename, "count_%d.txt", row);\n\n    // Count occurrences in the given row.\n    for (int j = 0; j < NUM_ELEMENTS; j++) {\n        if (matrix[row][j] == TARGET_NUMBER) {\n            count++;\n        }\n    }\n\n    // Write the count to a file specific to this process.\n    FILE *file = fopen(filename, "w");\n    if (file == NULL) {\n        perror("fopen");\n        exit(EXIT_FAILURE);\n    }\n    fprintf(file, "%d", count);\n    fclose(file);\n\n    exit(0);\n}\n\nint main() {\n    int matrix[NUM_PROCESSES][NUM_ELEMENTS];\n\n    // Initialize matrix for demonstration purposes.\n    for (int i = 0; i < NUM_PROCESSES; i++) {\n        for (int j = 0; j < NUM_ELEMENTS; j++) {\n            matrix[i][j] = j % 10; // Example initialization\n        }\n    }\n\n    pid_t pids[NUM_PROCESSES];\n    for (int i = 0; i < NUM_PROCESSES; i++) {\n        pids[i] = fork();\n        if (pids[i] < 0) {\n            perror("fork");\n            exit(EXIT_FAILURE);\n        } else if (pids[i] == 0) {\n            // Child process\n            childProcess(i, matrix);\n        }\n    }\n\n    // Wait for all child processes to finish.\n    for (int i = 0; i < NUM_PROCESSES; i++) {\n        wait(NULL);\n    }\n\n    int grandTotal = 0;\n    for (int i = 0; i < NUM_PROCESSES; i++) {\n        char filename[32];\n        sprintf(filename, "count_%d.txt", i);\n        FILE *file = fopen(filename, "r");\n        if (file == NULL) {\n            perror("fopen");\n            exit(EXIT_FAILURE);\n        }\n        int count;\n        fscanf(file, "%d", &count);\n        printf("Count from process %d: %d\n", i, count);\n        grandTotal += count;\n        fclose(file);\n        remove(filename); // Remove the file\n    }\n\n    printf("Grand Total: %d\n", grandTotal);\n\n    return 0;\n}