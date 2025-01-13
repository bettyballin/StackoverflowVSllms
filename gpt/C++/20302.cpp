#include <openssl/evp.h>\n#include <openssl/aes.h>\n#include <iostream>\n#include <vector>\n#include <cstring>\n\nvoid handleErrors() {\n    ERR_print_errors_fp(stderr);\n    abort();\n}\n\nstd::vector<unsigned char> aes_encrypt(const std::vector<unsigned char>& plaintext, const std::vector<unsigned char>& key, const std::vector<unsigned char>& iv) {\n    EVP_CIPHER_CTX* ctx = EVP_CIPHER_CTX_new();\n    if (!ctx) handleErrors();\n\n    int len;\n    std::vector<unsigned char> ciphertext(plaintext.size() + AES_BLOCK_SIZE);\n\n    if (1 != EVP_EncryptInit_ex(ctx, EVP_aes_256_cfb(), nullptr, key.data(), iv.data())) handleErrors();\n    if (1 != EVP_EncryptUpdate(ctx, ciphertext.data(), &len, plaintext.data(), plaintext.size())) handleErrors();\n    ciphertext.resize(len);\n    EVP_CIPHER_CTX_free(ctx);\n\n    return ciphertext;\n}\n\nint main() {\n    std::vector<unsigned char> key(32, '0'); // Your 256-bit key\n    std::vector<unsigned char> iv(AES_BLOCK_SIZE, '0'); // Your IV\n    std::vector<unsigned char> plaintext = { 'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd' };\n\n    std::vector<unsigned char> ciphertext = aes_encrypt(plaintext, key, iv);\n\n    std::cout << "Ciphertext: ";\n    for (unsigned char c : ciphertext) {\n        std::cout << std::hex << static_cast<int>(c) << " ";\n    }\n    std::cout << std::endl;\n\n    return 0;\n}