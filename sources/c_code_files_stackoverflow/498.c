#include <stdio.h>

int main() {
    int i;
    for(i = 2; i <= 6; i = i + 2) {
        printf("%d\t", i + 1);
    }
    return 0;
}