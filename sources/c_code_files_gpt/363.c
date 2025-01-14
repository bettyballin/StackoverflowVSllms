#include <stdio.h>
#include <stdlib.h>

#define MAX_VALUE 100

int main() {
    char input[10];
    printf("Enter a value: ");
    fgets(input, sizeof(input), stdin);
    input[strcspn(input, "\n")] = 0; // remove newline character

    int userInput = atoi(input);
    if (userInput > MAX_VALUE) {
        printf("Error: Input value exceeds maximum allowed value (%d)\n", MAX_VALUE);
        return 1; // return non-zero to indicate error
    }

    printf("You entered: %d\n", userInput);
    return 0;
}