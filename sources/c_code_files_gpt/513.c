#include <stdio.h>

int main() {
    int num;
    char buffer[256];
    fgets(buffer, sizeof(buffer), stdin);
    sscanf(buffer, "%d", &num);
    return 0;
}