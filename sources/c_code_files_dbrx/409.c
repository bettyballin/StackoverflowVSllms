#include <stdio.h>

#define MAX_LEN 1024

int main() {
    char input[MAX_LEN];
    fgets(input, sizeof(input), stdin); // reading input from console into the character array
    printf("%s", input); // print out the input string
    return 0;
}