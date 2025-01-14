#include <stdio.h>

int main() {
    int expression = 1; // Replace with your actual expression
    int expected_value = 1; // Replace with your actual expected value

    int result = __builtin_expect(expression, expected_value);

    printf("Result: %d\n", result);

    return 0;
}