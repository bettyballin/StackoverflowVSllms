#include <stdio.h>

int test_poweroftwo(unsigned int x) {
    if ((x & (x - 1)) == 0 && x != 0){ // Ensuring x is non-negative and not equal to zero is optional based on specific use case
        return 1; // Yes, x is a power of two.
    } else{
        return 0; // No, x is not a power of two.
    }
}

int main() {
    unsigned int num;
    printf("Enter a number: ");
    scanf("%u", &num);
    if (test_poweroftwo(num)) {
        printf("%u is a power of two.\n", num);
    } else {
        printf("%u is not a power of two.\n", num);
    }
    return 0;
}