// Example of AES encryption in C\n#include <openssl/aes.h>\n\nint main() {\n    AES_KEY aes_key;\n    unsigned char key[32]; // 256-bit key\n    unsigned char plaintext[16]; // 128-bit block\n    unsigned char ciphertext[16]; // 128-bit block\n\n    // Initialize AES key\n    AES_set_encrypt_key(key, 256, &aes_key);\n\n    // Encrypt plaintext\n    AES_encrypt(plaintext, ciphertext, &aes_key);\n\n    return 0;\n}