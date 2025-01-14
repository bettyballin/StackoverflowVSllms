#include <stdio.h>
#include <stdbool.h>

int main() {
    int number = 10; // replace with any number you want to check
    bool isEven = ((number & 0x01) == 0);
    printf("%d is even: %s\n", number, isEven ? "true" : "false");
    return 0;
}