#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *StringPadRight(const char *string, int padded_len, const char *pad) {
    int len = strlen(string);
    if (len >= padded_len) {
        char *result = (char *)malloc((len + 1) * sizeof(char));
        strcpy(result, string);
        return result;
    }

    int pad_len = strlen(pad);
    int total_pad_len = padded_len - len;

    // Allocate memory for the new string
    char *result = (char *)malloc((padded_len + 1) * sizeof(char));
    strcpy(result, string);

    // Append padding
    for (int i = 0; i < total_pad_len; i++) {
        result[len + i] = pad[i % pad_len];
    }
    result[padded_len] = '\0';

    return result;
}

int main() {
    char *padded_string = StringPadRight("Hello", 10, "0");
    printf("%s\n", padded_string); // Fixed the missing newline escape sequence
    free(padded_string); // Don't forget to free the allocated memory
    return 0;
}