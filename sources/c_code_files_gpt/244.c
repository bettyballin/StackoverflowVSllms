#include <stdio.h>
#include <string.h>
#include <openssl/blowfish.h>

#define BLOCK_SIZE 8

int main() {
    BF_KEY s_key;
    char plain[1000000]; // the plaintext of the message
    char cipher[1000000]; // the ciphertext of the message
    char msg[1000000]; // the input msg from the user
    char IV[8] = "MY*IV000"; // the initialization vector
    int q = 0; // index reader
    char in; // to read characters

    printf("Please enter the message you wish to send:\n");

    // Read the input message
    while ((in = getchar()) != '?') {
        msg[q++] = in;
    }
    msg[q] = '\0'; // truncate the string with the null character

    // Padding the message to make its length a multiple of BLOCK_SIZE
    int msg_len = strlen(msg);
    int pad_len = BLOCK_SIZE - (msg_len % BLOCK_SIZE);
    for (int i = 0; i < pad_len; i++) {
        msg[msg_len + i] = pad_len; // PKCS5 padding
    }
    msg[msg_len + pad_len] = '\0';
    msg_len += pad_len;

    // Set up the shared key of the BF encryption
    char dkey_buf[] = "your-secret-key"; // Replace with actual key
    BF_set_key(&s_key, strlen(dkey_buf), (unsigned char*)dkey_buf);

    // Encrypt the message
    BF_cbc_encrypt((unsigned char*)msg, (unsigned char*)cipher, msg_len, &s_key, (unsigned char*)IV, BF_ENCRYPT);

    // Decrypt the message
    BF_cbc_encrypt((unsigned char*)cipher, (unsigned char*)plain, msg_len, &s_key, (unsigned char*)IV, BF_DECRYPT);

    // Remove padding
    pad_len = plain[msg_len - 1];
    plain[msg_len - pad_len] = '\0';

    printf("plain after decryption: %s\n", plain);

    return 0;
}