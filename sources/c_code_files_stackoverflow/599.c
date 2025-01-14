#include <stdio.h>
#include <string.h>

#define CRYPT_BYTE 0x55 // Example byte for XOR operation

int main() {
    char originalString[] = "Hello, World!";
    char newString[sizeof(originalString)];

    // Ensure newString can hold the content of originalString including the null terminator
    if (sizeof(newString) < sizeof(originalString)) {
        fprintf(stderr, "Buffer size mismatch.\n");
        return 1;
    }

    for (size_t i = 0; i < strlen(originalString); ++i) {
        newString[i] = originalString[i] ^ CRYPT_BYTE;
    }
    newString[strlen(originalString)] = '\0'; // Ensure null termination

    printf("Original String: %s\n", originalString);
    printf("Encrypted String: %s\n", newString);

    // Optionally, decrypt it back
    for (size_t i = 0; i < strlen(originalString); ++i) {
        newString[i] = newString[i] ^ CRYPT_BYTE; // XORing again decrypts it
    }
    printf("Decrypted String: %s\n", newString);

    return 0;
}