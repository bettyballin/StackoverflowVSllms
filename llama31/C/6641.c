#include <openssl/sha.h>\n\nvoid sha256_hash(unsigned char* input, unsigned char* output, int size) {\n    SHA256_CTX ctx;\n    SHA256_Init(&ctx);\n    SHA256_Update(&ctx, input, size);\n    SHA256_Final(output, &ctx);\n}