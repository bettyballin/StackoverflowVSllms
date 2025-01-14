#include <stdio.h>

int main() {
    int expr1 = 1;
    int expr2 = 2;
    int expr3 = 3;

    int result = (expr1) ? (expr2) : (expr3);

    printf("Result: %d\n", result);

    return 0;
}