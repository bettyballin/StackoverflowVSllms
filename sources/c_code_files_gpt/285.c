#include <stdio.h>

int main() {
    int number;

    printf("Enter an integer: ");
    if (scanf("%d", &number) != 1) {
        // Handle error if input is not an integer
        printf("Invalid input. Please enter a valid integer.\n");
        return 1;
    }

    printf("You entered: %d\n", number);

    return 0;
}