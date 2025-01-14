#include <stdio.h>
#include <string.h>
#include <openssl/sha.h>

unsigned char *create_hash(unsigned char *data) {
    unsigned char hash[SHA_DIGEST_LENGTH];
    SHA1(data, strlen((char *)data), hash);
    // hash is a local variable and will be destroyed when function returns
    // we need to allocate memory and copy hash to it
    unsigned char *ret = malloc(SHA_DIGEST_LENGTH);
    memcpy(ret, hash, SHA_DIGEST_LENGTH);
    return ret;
}

int main() {
    unsigned char data[] = "Hello, World!";
    unsigned char *hash = create_hash(data);
    for (int i = 0; i < SHA_DIGEST_LENGTH; i++) {
        printf("%02x", hash[i]);
    }
    printf("\n");
    free(hash);
    return 0;
}