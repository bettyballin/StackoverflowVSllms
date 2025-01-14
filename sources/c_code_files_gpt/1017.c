#include <stdio.h>

int main() {
    char buffer[256];
    fgets(buffer, sizeof(buffer), stdin);
    return 0;
}