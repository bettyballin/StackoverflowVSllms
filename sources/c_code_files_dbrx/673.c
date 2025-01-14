#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char* StringPadRight(char* srcStr, int length, char padChar) {
    int srcLen = strlen(srcStr);
    char* paddedStr = (char*)malloc((length + 1) * sizeof(char));

    // Copy the original string to the new padded string
    strcpy(paddedStr, srcStr);

    // Pad the new string with the specified character
    for (int i = srcLen; i < length; i++) {
        paddedStr[i] = padChar;
    }

    // Null-terminate the padded string
    paddedStr[length] = '\0';

    return paddedStr;
}

int main() {
    char* srcStr = "Hello";
    char* paddedStr = StringPadRight(srcStr, 10, '0');
    printf("%s\n", paddedStr); /* print -> Hello00000 */
    free(paddedStr);  // Don't forget to free the allocated memory
    return 0; // exit code for successful execution.
}