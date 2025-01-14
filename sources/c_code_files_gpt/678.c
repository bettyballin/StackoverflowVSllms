#include <stdio.h>

int main() {
    int myFourcc = (('A' << 24) | ('B' << 16) | ('C' << 8) | 'D');
    printf("%d\n", myFourcc);
    return 0;
}