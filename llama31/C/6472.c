#include <openssl/sha.h>\n#include <stdio.h>\n\nint main() {\n    FILE *f = fopen("large_file", "rb");\n    SHA_CTX sha;\n    unsigned char hash[SHA_DIGEST_LENGTH];\n\n    SHA1_Init(&sha);\n    while (!feof(f)) {\n        unsigned char buffer[4096];\n        size_t len = fread(buffer, 1, 4096, f);\n        SHA1_Update(&sha, buffer, len);\n    }\n    SHA1_Final(hash, &sha);\n\n    for (int i = 0; i < SHA_DIGEST_LENGTH; i++) {\n        printf("%02x", hash[i]);\n    }\n    printf("\n");\n\n    fclose(f);\n    return 0;\n}