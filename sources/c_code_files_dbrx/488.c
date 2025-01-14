#include <stdio.h>

int sign(int i) {
    if (i > 0) return 1;
    else if (i == 0) return 0;
        // Else no need to check for less than, the value will be always < 0 by elimination.
    else return -1;
}

int main() {
    int num;
    printf("Enter a number: ");
    scanf("%d", &num);
    printf("Sign of %d is %d\n", num, sign(num));
    return 0;
}