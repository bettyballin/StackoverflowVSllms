char *getp() {\n    char *s = malloc(strlen("hello") + 1);\n    strcpy(s, "hello");\n    return s;\n}