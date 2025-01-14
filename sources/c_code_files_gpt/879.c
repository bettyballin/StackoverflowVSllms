#include <openssl/pem.h>
#include <openssl/rsa.h>
#include <openssl/sha.h>
#include <openssl/err.h>
#include <string.h>
#include <stdio.h>

// Function to verify product key
int verify_product_key(const char *product_key, unsigned char *signature, size_t signature_len) {
    FILE *fp = fopen("public_key.pem", "r");
    if (!fp) return -1;

    RSA *rsa = PEM_read_RSA_PUBKEY(fp, NULL, NULL, NULL);
    fclose(fp);
    if (!rsa) return -1;

    unsigned char hash[SHA256_DIGEST_LENGTH];
    SHA256((unsigned char*)product_key, strlen(product_key), hash);

    int result = RSA_verify(NID_sha256, hash, SHA256_DIGEST_LENGTH, signature, signature_len, rsa);
    RSA_free(rsa);

    return result == 1 ? 0 : -1;
}

int main() {
    // Example usage:
    unsigned char signature[] = {/* your signature bytes */};
    size_t signature_len = sizeof(signature);
    const char *product_key = "your_product_key";
    int result = verify_product_key(product_key, signature, signature_len);
    printf("Verification result: %d\n", result);
    return 0;
}