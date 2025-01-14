#include <stdio.h>

int main() {
    char input[100]; // declare a character array to store input
    gets(input); // reading input from console into the character array
    printf("%s\n", input); // print out the input string
    return 0;
}