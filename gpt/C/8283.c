#include <stdio.h>\n#include <stdlib.h>\n#include <string.h>\n\nvoid xor_cipher(char *data, size_t data_len, const char *key, size_t key_len) {\n    for (size_t i = 0; i < data_len; ++i) {\n        data[i] ^= key[i % key_len];\n    }\n}\n\nint main() {\n    char data[] = "Hello, World!";\n    const char *key = "secret";\n\n    printf("Original: %s\n", data);\n    \n    size_t data_len = strlen(data);\n    size_t key_len = strlen(key);\n\n    // Encrypt\n    xor_cipher(data, data_len, key, key_len);\n    printf("Encrypted: %s\n", data);\n\n    // Decrypt\n    xor_cipher(data, data_len, key, key_len);\n    printf("Decrypted: %s\n", data);\n\n    return 0;\n}