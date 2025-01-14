#include <stdio.h>

struct S {
    char data[100];
};

int main() {
    char c;
    int ascii = (int) c;
    struct S s2;
    int count = 65; // ASCII value of 'A'
    int j = 0;

    s2.data[j] = (char)count;

    printf("ASCII value: %d\n", ascii);
    printf("Character: %c\n", s2.data[j]);

    return 0;
}