#include <stdio.h>
#include <string.h>

typedef struct {
    char *data;
    size_t length;
} String;

void printString(const String *str) {
    for (size_t i = 0; i < str->length; ++i) {
        putchar(str->data[i]);
    }
    putchar('\n'); // corrected newline character
}

int main() {
    char rawData[] = "Hello\0World";
    String myString = { rawData, sizeof(rawData) };

    // Prints "Hello\0World" with the null character included
    printString(&myString);

    return 0;
}