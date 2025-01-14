#include <stdio.h>

// Example of tail-recursive function
int tail_recursive_function(int n, int acc) {
    if (n == 0) return acc;
    return tail_recursive_function(n - 1, acc + n);
}

int main() {
    int result = tail_recursive_function(10, 0);
    printf("%d\n", result);
    return 0;
}