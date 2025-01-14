#include <stdio.h>
#include <string.h>
#include <openssl/blowfish.h>

int main() {
    unsigned char key[16]; // Initialize key with some value
    unsigned char ivec[8];
    unsigned char inputz[] = "Hello, World!";
    unsigned char outputz[sizeof(inputz)];

    // Initialize key and ivec
    memset(key, 0, sizeof(key));
    for (int i = 0; i < 8; i++) ivec[i] = 'i';

    BF_KEY bf_key;
    BF_set_key(&bf_key, 16, key);

    BF_cbc_encrypt(inputz, outputz, strlen((char*)inputz), &bf_key, ivec, BF_ENCRYPT);

    // won't decrypt right:
    BF_cbc_encrypt(inputz, outputz, strlen((char*)inputz), &bf_key, ivec, BF_DECRYPT);
    // without resetting the ivec to all 'i's, the decryption will fail.

    // This would work though:
    for (int i = 0; i < 8; i++) ivec[i] = 'i';
    BF_cbc_encrypt(inputz, outputz, strlen((char*)inputz), &bf_key, ivec, BF_ENCRYPT);

    for (int i = 0; i < 8; i++) ivec[i] = 'i';
    BF_cbc_encrypt(inputz, outputz, strlen((char*)inputz), &bf_key, ivec, BF_DECRYPT);

    return 0;
}