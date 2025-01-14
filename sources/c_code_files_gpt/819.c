#include <stdio.h>

int main() {
    int myArray[5] = { 0, 1, 2, 3, 4 };

    printf("myArray[2] = %d\n", myArray[2]);
    printf("2[myArray] = %d\n", 2[myArray]);

    return 0;
}