#include <openssl/sha.h>
#include <string.h>

void generate_short_hash(const unsigned char *input, size_t input_len, unsigned char *output) {
    SHA256_CTX ctx;
    unsigned char raw[SHA256_DIGEST_LENGTH];

    memset(&ctx, 0x00, sizeof(SHA256_CTX));
    SHA256_Init(&ctx);
    SHA256_Update(&ctx, input, input_len);
    SHA256_Final(raw, &ctx);

    // Copy only the required number of bytes, but not more than the raw hash size
    size_t copy_len = 33 < SHA256_DIGEST_LENGTH ? 33 : SHA256_DIGEST_LENGTH;
    memcpy(output, raw, copy_len);
}

int main() {
    unsigned char input[] = "Hello, World!";
    unsigned char output[33];

    generate_short_hash(input, strlen((char*)input), output);

    return 0;
}