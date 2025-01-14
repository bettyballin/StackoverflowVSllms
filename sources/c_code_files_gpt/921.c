#include <stdio.h>

int calculate_hash(char* value, int length) {
    int hash = 0;
    for (int i = 0; i < length; i++) {
        hash = 31 * hash + value[i];
    }
    return hash;
}

int main() {
    char* str = "Hello, World!";
    int length = sizeof(str) - 1;  // subtract 1 to exclude the null terminator
    int hash = calculate_hash(str, length);
    printf("Hash: %d\n", hash);
    return 0;
}