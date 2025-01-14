#include <stdio.h>

int main() {
    int expression_one = 1;  // Replace with your actual expression
    int expression_two = 1;  // Replace with your actual expression

    int result1 = (!expression_one || !expression_two);
    int result2 = !(expression_one && expression_two);

    printf("Result 1: %d\n", result1);
    printf("Result 2: %d\n", result2);

    return 0;
}