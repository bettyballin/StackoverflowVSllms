#include <math.h>

#define CHAR_SIZE 8

typedef unsigned char *Set;

void addint(Set *S, int n) {
    (*S)[n/CHAR_SIZE] |= (unsigned char) pow(2, (CHAR_SIZE - 1) - (n % CHAR_SIZE));
}