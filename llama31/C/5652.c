#include <stdio.h>\n#include <stdlib.h>\n#include <string.h>\n#include <time.h>\n\nvoid shuffle(char *str) {\n    int len = strlen(str);\n    for (int i = len - 1; i > 0; i--) {\n        int j = rand() % (i + 1);\n        char temp = str[i];\n        str[i] = str[j];\n        str[j] = temp;\n    }\n}\n\nint main() {\n    srand(time(NULL)); // seed the random number generator\n    char str[] = "your_80_character_string_here";\n    for (int i = 0; i < 100000; i++) {\n        shuffle(str);\n        // do something with the shuffled string\n        printf("%s\n", str);\n    }\n    return 0;\n}