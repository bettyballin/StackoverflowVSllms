#include <stdio.h>

int main() {
    float f = 3.14;
    size_t t = *((size_t*)&f);
    printf("%zu\n", t);
    return 0;
}