#include <string.h>

void secureEraseSensitiveData(char* sensitiveData, size_t dataSize) {
    volatile char* p = sensitiveData;
    for (size_t i = 0; i < dataSize; ++i) {
        *p++ = 0;
    }
}

int main() {
    char password[] = "SuperSecretPassword";
    // Use the password for authentication or encryption...

    // Securely erase the password when done
    size_t len = strlen(password);
    secureEraseSensitiveData(password, len + 1); // +1 to also clear the null terminator

    return 0;
}