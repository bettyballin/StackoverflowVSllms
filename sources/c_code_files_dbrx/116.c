#include <stdio.h>
#include <unistd.h>

int main() {
    int x;
    printf("Enter value of x: ");
    scanf("%d", &x); 
    if (isatty(STDIN_FILENO)) {
        printf("Value entered interactively: %d\n", x);
    } else {
        printf("Value came from a file:\n");
    }
    return 0;
}