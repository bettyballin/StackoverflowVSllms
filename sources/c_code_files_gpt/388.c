#include <stdio.h>

int main() {
    char *p = "hello";
    char *q = "hello";

    for ( ; *p == *q; p++, q++) {
        // loop body
        printf("%c\n", *p);
    }

    return 0;
}