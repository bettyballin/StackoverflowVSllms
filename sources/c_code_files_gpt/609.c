#include <stdio.h>

int main() {
    freopen("C:\\path\\to\\file.in", "r", stdin);
    freopen("C:\\path\\to\\file.out", "w", stdout);
    printf("somedata\n");
    return 0;
}