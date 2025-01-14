#include <stdio.h>
#include <stdlib.h>

void foo1(char *p1) {
    printf("foo1: %s\n", p1);
}

char* foo2(void) {
    char* str = malloc(20 * sizeof(char));
    sprintf(str, "Hello from foo2!");
    return str;
}

int main(int argc, char *argv[]) {
    char* str = foo2();
    foo1(str);
    free(str);
    return 0;
}