#include <stdio.h>

int main() {
    char *p = "Hello";
    char *q = "Hello";

    for ( ; *p == *q; p++, q++) {
        // You can add some code here if you want to do something
        // when the characters match
    }

    return 0;
}