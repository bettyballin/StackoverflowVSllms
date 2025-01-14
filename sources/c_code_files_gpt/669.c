#include <stdio.h>
#include <string.h>

typedef struct {
    char data[1024]; // Assuming a fixed-size buffer for demonstration purposes
} Stringpool_char;

int main() {
    Stringpool_char ret;
    char s[] = "Hello, World!";
    size_t len = strlen(s) + 1; // Include the null terminator

    // Ensure the buffer is large enough to hold the string
    if (len > sizeof(ret.data)) {
        printf("Buffer overflow detected!\n");
        return 1;
    }

    memcpy(ret.data, s, len - 1); // Subtract 1 to exclude the null terminator

    printf("Copied string: %s\n", ret.data);

    return 0;
}