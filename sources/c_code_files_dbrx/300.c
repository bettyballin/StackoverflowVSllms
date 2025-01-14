#include <stdio.h>
#include <openssl/aes.h>

int main() {
    unsigned char input[1024];
    unsigned char output[1024];
    AES_KEY aeskey;

    // Initialize the AES key (replace with your own key)
    unsigned char key[16] = {0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07,
                             0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f};
    AES_set_encrypt_key(key, 128, &aeskey);

    // Replace with your own input data
    for (int i = 0; i < 1024; i++) {
        input[i] = i;
    }

    AES_ofb128_encrypt(input, output, 1024, &aeskey, key, AES_ENCRYPT);

    for (int i = 0; i < 1024; i++) {
        printf("%02x", output[i]);
    }
    printf("\n");

    return 0;
}