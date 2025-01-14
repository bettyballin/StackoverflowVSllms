#include <stdio.h>

int main() {
    int x = 5; // example value
    int d = 3; // example value

    x = (x - d - 1 + 12) % 12 + 1;

    printf("%d\n", x);

    return 0;
}