#include <stdio.h>

int main() {
    int x;
    printf("Enter value of x (from keyboard): ");
    scanf("%d", &x); // this reads from stdin, even when input is redirected or used through a pipe
    printf("Value from regular input: %d\n", x);
    return 0;
}