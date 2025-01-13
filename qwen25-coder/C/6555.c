#include <stdio.h>\n#include <string.h>\n\nvoid print_line(const char *tag, int data) {\n    int width = 40; // Total line width including tag and brackets\n    int tag_length = strlen(tag);\n    int dot_count = width - tag_length - 3; // Subtract 3 for the space before [ and ] after\n    printf("%s ", tag);\n    for (int i = 0; i < dot_count; i++) {\n        putchar('.');\n    }\n    printf(" [%d]\n", data);\n}\n\nvoid print_line_str(const char *tag, const char *data) {\n    int width = 40;\n    int tag_length = strlen(tag);\n    int dot_count = width - tag_length - strlen(data) - 3;\n    printf("%s ", tag);\n    for (int i = 0; i < dot_count; i++) {\n        putchar('.');\n    }\n    printf(" [%s]\n", data);\n}\n\nint main() {\n    print_line("Number of cards", 500);\n    print_line("Fixed prize amount [in whole dollars]", 10);\n    print_line_str("Is this a high winner prize?", "yes");\n    return 0;\n}