#include <string.h>

int main() {
    char src[] = "Hello, world!"; // Define the src variable
    char dest[256];
    strncpy(dest, src, sizeof(dest) - 1);
    dest[sizeof(dest) - 1] = '\0'; // Ensure null-termination
    return 0;
}