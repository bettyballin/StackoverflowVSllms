#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define FORMATTED_STRING_MAX_LEN 256

int main() {
    char formatted[FORMATTED_STRING_MAX_LEN]; 
    char final_string[256] = "Some sample prepend text "; 
    int start, length;

    sprintf(formatted, "%s:%d", "Insert some data", 42); 

    start = strlen(final_string);
    length = strlen(formatted) > FORMATTED_STRING_MAX_LEN - 1 - start ? FORMATTED_STRING_MAX_LEN - start - 1 : strlen(formatted); 

    // Ensure the final string has enough space to hold the formatted string
    if (start + length >= sizeof(final_string)) {
        fprintf(stderr, "Buffer overflow detected!\n");
        return 1;
    }

    memcpy(&final_string[start], formatted, length); 
    final_string[start + length] = '\0';  // Add null terminator

    printf("Formatted string: %s\n", final_string); 
    return 0;
}