#include <openssl/pem.h>
#include <openssl/rsa.h>
#include <openssl/sha.h>
#include <openssl/err.h>
#include <string.h>

// Function to sign product key
int sign_product_key(const char *product_key, unsigned char *signature, size_t *signature_len) {
    FILE *fp = fopen("private_key.pem", "r");
    if (!fp) return -1;

    RSA *rsa = PEM_read_RSAPrivateKey(fp, NULL, NULL, NULL);
    fclose(fp);
    if (!rsa) return -1;

    unsigned char hash[SHA256_DIGEST_LENGTH];
    SHA256((unsigned char*)product_key, strlen(product_key), hash);

    if (RSA_sign(NID_sha256, hash, SHA256_DIGEST_LENGTH, signature, (unsigned int*)signature_len, rsa) != 1) {
        RSA_free(rsa);
        return -1;
    }

    RSA_free(rsa);
    return 0;
}

int main() {
    const char *product_key = "your_product_key_here";
    unsigned char signature[256];
    size_t signature_len = 256;

    int ret = sign_product_key(product_key, signature, &signature_len);
    if (ret != 0) {
        printf("Error signing product key\n");
        return 1;
    }

    printf("Product key signed successfully\n");
    return 0;
}