#include <stdio.h>

int main() {
    register int test_integer asm ("EBX");
    printf("%d\n", test_integer);
    return 0;
}