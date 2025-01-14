#include <stdio.h>

int pow(int base, int exp) {
    if (exp < 0) {
        return -1; // Handle negative exponents if necessary
    }
    
    int result = 1;
    while (exp > 0) {
        if (exp % 2 == 1) {
            result *= base;
        }
        base *= base;
        exp /= 2;
    }
    return result;
}

int main() {
    printf("%d\n", pow(2, 3)); // Output: 8
    printf("%d\n", pow(5, 5)); // Output: 3125
    return 0;
}