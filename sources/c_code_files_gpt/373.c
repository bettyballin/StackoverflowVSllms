#include <stdio.h>

int main() {
    char buffer[100];
    // Using fgets() as a safer alternative to gets()
    if (fgets(buffer, sizeof(buffer), stdin) != NULL) {
        printf("%s", buffer);
    }
    return 0;
}