#include <stdio.h>

int main() {
    // Array of 800000 chars
    char word1[800000] = "Hello";
    printf("%s\n", word1);  // Prints "Hello"

    // Array of 800000 char pointers
    char *word2[800000];
    word2[0] = "Hello";
    word2[1] = "World";
    printf("%s %s\n", word2[0], word2[1]);  // Prints "Hello World"

    return 0;
}