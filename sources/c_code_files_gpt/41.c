#include <stdio.h>
#include <string.h>

int main() {
    char str1[50] = "1";
    char str2[] = "1";
    
    // Concatenate str2 onto str1
    strcat(str1, str2);
    
    // Print the result
    printf("Concatenated string: %s\n", str1);
    
    return 0;
}