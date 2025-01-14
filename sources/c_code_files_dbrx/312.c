#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Function to remove trailing zeros from a float string
char* RemoveTrailingZeros(char* str) {
    char* p;
    int len = strlen(str);
    p = strchr(str, '.');
    if (p) {
        p = p + len - 1;
        while (*p == '0') {
            *p = '\0';
            p--;
            if (p == strchr(str, '.') - 1) {
                *p = '\0';
                break;
            }
        }
    }
    return str;
}

// Wrapper function to allocate memory and convert float to string
char* RemoveTrailingZerosWrapper(float* value) {
    char* buffer = (char*)malloc(32); // Allocate memory for the string
    if (buffer) {
        sprintf(buffer, "%.1f", *value); // Convert float to string with one decimal place
        RemoveTrailingZeros(buffer);
    }
    return buffer;
}

int main() {
    float myFloat = 15.6f;
    int myInt = 3;
    char out[256];
    char* strFloat = RemoveTrailingZerosWrapper(&myFloat);
    if (strFloat) {
        snprintf(out, sizeof(out), "%d %s", myInt, strFloat);
        printf("%s\n", out); // prints: 3 15.6
        free(strFloat); // Don't forget to free the allocated memory
    } else {
        printf("Memory allocation failed.\n");
    }
    return 0;
}