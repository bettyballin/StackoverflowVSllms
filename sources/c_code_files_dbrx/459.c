#include <stdio.h>

int sign(int i) {
   if (i > 0) return 1;
   if (i == 0) return 0;
        // If none of the above is true, the input must be less than zero.
     return -1;
}

int main() {
    printf("%d\n", sign(5));  // Test with a positive number
    printf("%d\n", sign(0));  // Test with zero
    printf("%d\n", sign(-5)); // Test with a negative number
    return 0;
}