#include <stdio.h>

unsigned int hash(int x) {
   return (((x ^ 0xf7f7f7f7) * 0x8364abf7) ^ 0xf00bf00b) * 0xf81bc437;
}

int main() {
    int x;
    printf("Enter an integer: ");
    scanf("%d", &x);
    printf("Hash value: %u\n", hash(x));
    return 0;
}