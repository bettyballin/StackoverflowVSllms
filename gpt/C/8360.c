#include <stdio.h>\n\nint main() {\n    char filename[20];\n    FILE *fp;\n    for (int i = 1; i <= 77; ++i) {\n        snprintf(filename, sizeof(filename), "file%d", i);\n        fp = fopen(filename, "w");\n        if (fp != NULL) {\n            fputs(filename, fp);\n            fclose(fp);\n        }\n    }\n    return 0;\n}