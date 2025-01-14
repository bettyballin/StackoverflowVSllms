#include <stdio.h>
#include <string.h>

int main() {
    char tag[] = "ExampleTag"; // Example tag
    int data = 123; // Example data

    fprintf(stdout, "%40s[%d]", tag, data); /* 40 is (width + length of text) */
    /* Then print '-' after fprintf to complete the line as desired*/
    for (int i = strlen(tag); i < 39; i++) printf("-");
    printf("\n"); // Changed "\r" to "\n" for Unix-like line ending

    return 0;
}