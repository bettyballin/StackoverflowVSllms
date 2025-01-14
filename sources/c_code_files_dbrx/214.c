#include <stdio.h>

int main() {
    char str[10];
    fgets(str, sizeof(str), stdin);
    return 0;
}