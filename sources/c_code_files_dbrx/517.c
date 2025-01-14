#include <stdio.h>

int __cdecl AddNumbers(int num1, int num2) {
    return num1 + num2;
}

int main() {
    int result = AddNumbers(5, 7);
    printf("Result: %d\n", result);
    return 0;
}