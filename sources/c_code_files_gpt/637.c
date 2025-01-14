#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void xor_cipher(char *data, size_t data_len, const char *key, size_t key_len) {
    for (size_t i = 0; i < data_len; ++i) {
        data[i] ^= key[i % key_len];
    }
}

int main() {
    char data[] = "Hello, World!";
    const char *key = "secret";

    printf("Original: %s\n", data);
    
    size_t data_len = strlen(data);
    size_t key_len = strlen(key);

    // Encrypt
    xor_cipher(data, data_len, key, key_len);
    printf("Encrypted: %s\n", data);

    // Decrypt
    xor_cipher(data, data_len, key, key_len);
    printf("Decrypted: %s\n", data);

    return 0;
}