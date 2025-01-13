#include <stdio.h>\n#include <stdlib.h>\n\nint main() {\n    char *buffer;\n    size_t bufsize = 32;\n    size_t characters;\n\n    buffer = (char *)malloc(bufsize * sizeof(char));\n    if (buffer == NULL) {\n        perror("Unable to allocate buffer");\n        exit(1);\n    }\n\n    printf("Enter a line of text:\n");\n    characters = getline(&buffer, &bufsize, stdin);\n    printf("You entered: %s", buffer);\n\n    free(buffer);\n    return 0;\n}