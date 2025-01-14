#include <openssl/rsa.h>
#include <openssl/pem.h>
#include <openssl/err.h>
#include <stdio.h>
#include <string.h>

void EncryptWithPublicKey(const char* publicKeyFile, const char* plaintext, const char* outputFile)
{
    // Open the public key file
    FILE* pubKeyFile = fopen(publicKeyFile, "rb");
    if (!pubKeyFile)
    {
        perror("Failed to open public key file");
        return;
    }

    // Read the RSA public key from the file
    RSA* rsa = PEM_read_RSA_PUBKEY(pubKeyFile, NULL, NULL, NULL);
    fclose(pubKeyFile);

    if (!rsa)
    {
        ERR_print_errors_fp(stderr);
        return;
    }

    // Encrypt the plaintext
    unsigned char encrypted[256];
    int result = RSA_public_encrypt(strlen(plaintext), (unsigned char*)plaintext, encrypted, rsa, RSA_PKCS1_OAEP_PADDING);
    if (result == -1)
    {
        ERR_print_errors_fp(stderr);
        RSA_free(rsa);
        return;
    }

    // Write the encrypted data to the output file
    FILE* outFile = fopen(outputFile, "wb");
    if (!outFile)
    {
        perror("Failed to open output file");
        RSA_free(rsa);
        return;
    }
    fwrite(encrypted, sizeof(unsigned char), result, outFile);
    fclose(outFile);

    RSA_free(rsa);
}

int main(int argc, char* argv[])
{
    if (argc != 4)
    {
        fprintf(stderr, "Usage: %s <public_key_file> <plaintext> <output_file>\n", argv[0]);
        return 1;
    }

    const char* publicKeyFile = argv[1];
    const char* plaintext = argv[2];
    const char* outputFile = argv[3];

    EncryptWithPublicKey(publicKeyFile, plaintext, outputFile);

    return 0;
}