#include <stdio.h>

#define MIN_VALUE 0
#define MAX_VALUE 100

int main() {
    int input_value;

    // Get the input value from the user
    printf("Enter a value: ");
    scanf("%d", &input_value);

    if (input_value < MIN_VALUE || input_value > MAX_VALUE) {
        // Handle invalid input
        printf("Invalid input! Please enter a value between %d and %d.\n", MIN_VALUE, MAX_VALUE);
    } else {
        // Handle valid input
        printf("You entered a valid value: %d\n", input_value);
    }

    return 0;
}