#include <openssl/aes.h>\n\n// Set up the encryption context\nAES_KEY aes_key;\nAES_set_encrypt_key(key, 128, &aes_key);\n\n// Encrypt the data\nunsigned char* encrypted_data = malloc(data_len);\nAES_encrypt(data, encrypted_data, &aes_key);\n\n// Decrypt the data\nunsigned char* decrypted_data = malloc(data_len);\nAES_decrypt(encrypted_data, decrypted_data, &aes_key);