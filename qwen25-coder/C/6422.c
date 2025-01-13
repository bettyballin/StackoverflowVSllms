#include <stdio.h>\n#include <string.h>\n\ntypedef enum {\n    TOKEN_EOF,\n    TOKEN_NUMBER,\n    TOKEN_PLUS,\n    TOKEN_MINUS,\n    TOKEN_MULTIPLY,\n    TOKEN_DIVIDE\n} TokenType;\n\ntypedef struct {\n    TokenType type;\n    double value;\n} Token;\n\nToken get_next_token(const char **text) {\n    while (**text == ' ') (*text)++;\n    \n    if (**text == '\0') return (Token){TOKEN_EOF, 0};\n    if (**text == '+') {(*text)++; return (Token){TOKEN_PLUS, 0};}\n    if (**text == '-') {(*text)++; return (Token){TOKEN_MINUS, 0};}\n    if (**text == '*') {(*text)++; return (Token){TOKEN_MULTIPLY, 0};}\n    if (**text == '/') {(*text)++; return (Token){TOKEN_DIVIDE, 0};}\n\n    if (**text >= '0' && **text <= '9') {\n        double value = strtod(*text, (char **)text);\n        return (Token){TOKEN_NUMBER, value};\n    }\n\n    fprintf(stderr, "Unknown character: %c\n", **text);\n    exit(1);\n}