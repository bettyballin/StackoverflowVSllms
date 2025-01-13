#include <stdio.h>\n#include <stdlib.h>\n\nint main() {\n    FILE *fp;\n    char path[1035];\n\n    /* Open the command for reading. */\n    fp = popen("ls -l", "r");\n    if (fp == NULL) {\n        printf("Failed to run command\n" );\n        exit(1);\n    }\n\n    /* Read the output a line at a time - output it. */\n    while (fgets(path, sizeof(path)-1, fp) != NULL) {\n        printf("%s", path);\n    }\n\n    /* Close the file pointer and return the exit status of pclose(). */\n    pclose(fp);\n\n    return 0;\n}