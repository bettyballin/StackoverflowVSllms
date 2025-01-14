#include <stdio.h>

int sign(int i) {
    if (i > 0) {
        return 1;
    } else if (i == 0) {
        return 0;
    } else { // i < 0
        return -1;
    }
}

int main() {
    int num;
    printf("Enter a number: ");
    scanf("%d", &num);
    printf("Sign of %d is %d\n", num, sign(num));
    return 0;
}