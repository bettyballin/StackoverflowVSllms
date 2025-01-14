#include <stdio.h>

typedef char somechar[40];

int main() {
    somechar str = "Hello, World!";
    printf("%s\n", str);
    return 0;
}