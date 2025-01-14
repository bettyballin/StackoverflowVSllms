#include <stdio.h>
#include <string.h>

// Dummy function to simulate signing a product key.
// Returns 0 on success, -1 on failure.
int sign_product_key(const char *product_key, unsigned char *signature, size_t *signature_len) {
    // This is a placeholder for your actual signing logic.
    // For demonstration, it simply copies the product_key into the signature buffer.
    size_t key_len = strlen(product_key);
    if (key_len > *signature_len) {
        return -1; // Failure: signature buffer too small
    }
    memcpy(signature, product_key, key_len);
    *signature_len = key_len;
    return 0; // Success
}

// Dummy function to simulate verifying a signed product key.
// Returns 0 on success, -1 on failure.
int verify_product_key(const char *product_key, unsigned char *signature, size_t signature_len) {
    // This is a placeholder for your actual verification logic.
    // For demonstration, it simply checks if the signature matches the product_key.
    return strncmp(product_key, (char*)signature, signature_len) == 0 ? 0 : -1;
}

int main() {
    const char *product_key = "aaaaa-bbbbb-ccccc-ddddd-eeeee";
    unsigned char signature[256];
    size_t signature_len = sizeof(signature);

    if (sign_product_key(product_key, signature, &signature_len) == 0) {
        printf("Product key signed successfully.\n");

        if (verify_product_key(product_key, signature, signature_len) == 0) {
            printf("Product key verified successfully.\n");
        } else {
            printf("Failed to verify product key.\n");
        }
    } else {
        printf("Failed to sign product key.\n");
    }

    return 0;
}