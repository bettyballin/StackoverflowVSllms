#include <stdio.h>

enum { Val1, Val2, Val3 } someEnum;

int main() {
    // You can use the enum values like this:
    someEnum = Val2;
    printf("%d\n", someEnum);
    return 0;
}