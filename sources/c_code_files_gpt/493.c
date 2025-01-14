#include <stdio.h>

int __initstdio1(void);

typedef int (*_PIFV)(void);

int z = 1;

void __attribute__((constructor)) initstdio1(void) {
    z = 100;
}

int main(void) {
    printf("Some code before main!\n");
    printf("z = %d\n", z);
    printf("End!\n");
    return 0;
}