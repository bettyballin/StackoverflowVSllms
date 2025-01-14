#include <stdio.h>

int main() {
    int num;

    printf("Enter an integer number: ");

    if (scanf("%d", &num) != 1) { // validate input
        fprintf(stderr, "Invalid input\n");
        return -1;
    }

    printf("You entered %d.\n", num);

    return 0;
}