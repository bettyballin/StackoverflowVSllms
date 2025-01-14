#include <stdio.h>

enum { Val1, Val2, Val4, Val3 }; // Added Val4 between Val2 and Val3

int main() {
    printf("Val1: %d\n", Val1);
    printf("Val2: %d\n", Val2);
    printf("Val4: %d\n", Val4);
    printf("Val3: %d\n", Val3);
    return 0;
}