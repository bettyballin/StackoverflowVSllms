#define _XOPEN_SOURCE 500
#include <stdlib.h>
#include <stdio.h>

int main() {
    srandom(42);
    long int rand_num = random();
    printf("Random number: %ld\n", rand_num);
    return 0;
}