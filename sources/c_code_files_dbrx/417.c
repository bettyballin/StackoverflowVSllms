#include <stdio.h>
#include <math.h>

#define CHAR_SIZE 8

int main() {
    unsigned char (*S)[1] = (unsigned char (*)[1]) malloc(sizeof(unsigned char));
    int n = 5;  // example value for n

    (*S)[n/CHAR_SIZE] |= (unsigned char) pow(2, (CHAR_SIZE - 1) - (n % CHAR_SIZE));

    // Print the result for verification
    printf("%d\n", (*S)[n/CHAR_SIZE]);

    free(S);
    return 0;
}