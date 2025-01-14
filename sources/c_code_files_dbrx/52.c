#include <openssl/rsa.h>
#include <openssl/pem.h>
#include <string.h>
#include <stdlib.h>
#include <stdio.h>

int main() {
    RSA* rsa = RSA_generate_key(2048, RSA_F4, NULL, NULL);
    if (rsa == NULL) {
        printf("Error generating RSA key.\n");
        return 1;
    }

    const char* message = "RSA Encryption Test.";
    int plainLen = strlen(message) + 1;
    unsigned char* encrypted = (unsigned char*) malloc(RSA_size(rsa));
    if (encrypted == NULL) {
        printf("Error allocating memory for encrypted data.\n");
        RSA_free(rsa);
        return 1;
    }

    int encryptedLen = RSA_public_encrypt(plainLen, (unsigned char *)message, encrypted, rsa, RSA_PKCS1_PADDING);
    if (encryptedLen == -1) {
        printf("Error during encryption.\n");
        RSA_free(rsa);
        free(encrypted);
        return 1;
    }

    unsigned char* decrypted = (unsigned char*) malloc(RSA_size(rsa));
    if (decrypted == NULL) {
        printf("Error allocating memory for decrypted data.\n");
        RSA_free(rsa);
        free(encrypted);
        return 1;
    }

    int decryptedLen = RSA_private_decrypt(encryptedLen, encrypted, decrypted, rsa, RSA_PKCS1_PADDING);
    if (decryptedLen == -1) {
        printf("Error during decryption.\n");
        RSA_free(rsa);
        free(encrypted);
        free(decrypted);
        return 1;
    }

    printf("Decrypted message: %s\n", decrypted);

    RSA_free(rsa);
    free(encrypted);
    free(decrypted);

    return 0;
}