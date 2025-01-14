#include <stdio.h>
#include <string.h>
#include <openssl/sha.h>

void sha256_hash(char *input, char outputBuffer[65]) {
    unsigned char digest[SHA256_DIGEST_LENGTH];
    SHA256_CTX ctx;

    // Initialize SHA-256 context and hash input string
    SHA256_Init(&ctx);
    SHA256_Update(&ctx, input, strlen(input));
    SHA256_Final(digest, &ctx);

    // Create hexadecimal output string and store it in the provided buffer
    for (int i = 0; i < SHA256_DIGEST_LENGTH; ++i) {
        sprintf(&outputBuffer[i * 2], "%02x", digest[i]);
    }
}

int main() {
    char input[] = "Hello, World!";
    char output[65];

    sha256_hash(input, output);

    printf("SHA-256 hash of '%s': %s\n", input, output);

    return 0;
}