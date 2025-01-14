#include <stdio.h>

int main() {
    int a = ({
        int i;
        int t = 1;
        for (i = 2; i < 5; i++) {
            t *= i;
        }
        t; // The value of the entire expression is the value of this last statement
    });

    printf("%d\n", a);
    return 0;
}