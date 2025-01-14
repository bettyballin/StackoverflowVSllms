#define _XOPEN_SOURCE
#include <stdio.h>
#include <stdlib.h>

int main() {
    // seed the random number generator
    srandom(1);

    // generate a random number
    int rand_num = random();

    // print the random number
    printf("%d\n", rand_num);

    return 0;
}