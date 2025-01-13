#include <stdio.h>\n#include <stdlib.h>\n\nint main() {\n    FILE *fp;\n    char buffer[128];\n    char returnData[500];\n\n    /* Open the command for reading. */\n    fp = popen("/usr/bin/php -q /var/www/html/phpinfo.php", "r");\n    if (fp == NULL) {\n        printf("Failed to run command\n" );\n        exit(1);\n    }\n\n    /* Read the output a line at a time - output it. */\n    while (fgets(buffer, sizeof(buffer)-1, fp) != NULL) {\n        strcat(returnData, buffer);\n    }\n\n    /* close */\n    pclose(fp);\n\n    printf("End php function\n");\n    printf("PHP output: %s", returnData);\n\n    return 0;\n}