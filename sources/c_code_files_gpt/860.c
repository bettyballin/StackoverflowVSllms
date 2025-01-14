#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Function to create a string
char* createString() {
    char* str = (char*)malloc(20 * sizeof(char));
    strcpy(str, "Hello, World!");
    return str;
}

int main() {
    char* myStr = createString();
    printf("%s\n", myStr);  // Use myStr
    free(myStr);
    return 0;
}