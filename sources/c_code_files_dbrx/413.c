#include <stdio.h>

int main() {
    int a = 10; // initialize a with some value
    int b = 2;  // initialize b with some value
    int p = 0;

    for(p=0; p+= (a&1)*b, a!=1; a>>=1, b<<=1);

    printf("Final value of p: %d\n", p);

    return 0;
}