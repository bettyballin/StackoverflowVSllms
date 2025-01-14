#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <openssl/md5.h>

// Function to compute MD5 hash
void compute_md5(const char *str, unsigned char digest[MD5_DIGEST_LENGTH]) {
    MD5_CTX ctx;
    MD5_Init(&ctx);
    MD5_Update(&ctx, str, strlen(str));
    MD5_Final(digest, &ctx);
}

int main() {
    const char *input = "Your input string here";
    unsigned char digest[MD5_DIGEST_LENGTH];
    compute_md5(input, digest);

    printf("MD5 digest: ");
    for(int i = 0; i < MD5_DIGEST_LENGTH; i++) {
        printf("%02x", digest[i]);
    }
    printf("\n");

    return 0;
}