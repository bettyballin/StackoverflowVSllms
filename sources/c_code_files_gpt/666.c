#include <stdio.h>

int main() {
    int myArray[10];
    myArray[9] = 42;  // Fixed out-of-bounds write
    printf("%d\n", myArray[9]);
    return 0;
}