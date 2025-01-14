#include <stdio.h>

long factorial(int n) {
    long result = 1;

    if (n == 0 || n == 1) {
        return 1;
    } else {
        return n * factorial(n - 1);
    }
}

int main() {
    int i;

    for (i = 1; i <= 10; ++i)
        printf("%d! = %ld\n", i, factorial(i));

    return 0;
}