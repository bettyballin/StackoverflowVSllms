#include <stdio.h>

__attribute__((fastcall)) int add_numbers(int a, int b) {
    return a + b;
}

int main() {
    int a = 5;
    int b = 7;
    int sum = add_numbers(a, b);
    printf("The sum of %d and %d is %d\n", a, b, sum);
    return 0;
}