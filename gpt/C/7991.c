#include <stdio.h>\n#include <stdlib.h>\n#include <string.h>\n\nchar *StringPadRight(const char *string, int padded_len, const char *pad) {\n    int len = strlen(string);\n    if (len >= padded_len) {\n        char *result = (char *)malloc((len + 1) * sizeof(char));\n        strcpy(result, string);\n        return result;\n    }\n\n    int pad_len = strlen(pad);\n    int total_pad_len = padded_len - len;\n\n    // Allocate memory for the new string\n    char *result = (char *)malloc((padded_len + 1) * sizeof(char));\n    strcpy(result, string);\n\n    // Append padding\n    for (int i = 0; i < total_pad_len; i++) {\n        result[len + i] = pad[i % pad_len];\n    }\n    result[padded_len] = '\0';\n\n    return result;\n}\n\nint main() {\n    char *padded_string = StringPadRight("Hello", 10, "0");\n    printf("%s\n", padded_string);\n    free(padded_string); // Don't forget to free the allocated memory\n    return 0;\n}