#include <stdio.h>

int main() {
    int condition = 1;
    int value_if_true = 10;
    int value_if_false = 20;
    int result = condition ? value_if_true : value_if_false;
    printf("Result: %d\n", result);
    return 0;
}