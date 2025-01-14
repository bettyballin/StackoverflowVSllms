#include <openssl/aes.h>
#include <stdio.h>
#include <string.h>

int main() {
    // Define the input and output buffers
    unsigned char input[1024];
    unsigned char output[1024];

    // Define the AES key
    AES_KEY aeskey;

    // Initialize the AES key
    AES_set_encrypt_key("0123456789abcdef", 128, &aeskey);

    // Copy some data into the input buffer
    memcpy(input, "Hello, World!", 13);

    // Perform the AES-OFB encryption
    AES_ofb128_encrypt(input, output, 13, &aeskey, NULL);

    // Print the encrypted output
    printf("Encrypted output: ");
    for (int i = 0; i < 13; i++) {
        printf("%02x", output[i]);
    }
    printf("\n");

    return 0;
}