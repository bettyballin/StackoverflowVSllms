#include <stdio.h>

int main() {
    int condition1 = 1; // example condition 1
    int condition2 = 0; // example condition 2

    int result = !(condition1 && condition2); // this will return TRUE if either condition is FALSE

    printf("Result: %d\n", result);

    return 0;
}