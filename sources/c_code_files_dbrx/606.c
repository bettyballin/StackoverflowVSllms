#include <stdio.h>
#include <stdlib.h>
#include <gcrypt.h>

int main(int argc, char *argv[]) {
    gcry_error_t err;
    gcry_cipher_hd_t hd;
    int rnd;
    const char *secret = "This is my secret.";
    unsigned char *random_key;
    unsigned char crypted[256];
    unsigned char recoveredtext[256];
    char plaintext[256];
    size_t random_len = 16384/8*9+20; /* generate enough for AES-192 & IV */
    random_key = malloc(random_len);

    err = gcry_create_nonce(random_key, random_len);
    if (err){
        fprintf(stderr, "%s\n", gcry_strsource(err));
        return 1;
    } else { 
        /* encryption */
        err = gcry_cipher_open(&hd, GCRY_CIPHER_3DES, GCRY_CIPHER_MODE_CFB, 0);
        if (err) {
            fprintf(stderr, "%s\n", gcry_strsource(err));
            return 1;
        }
        gcry_cipher_setkey(hd, random_key, 56);
        gcry_cipher_setiv(hd, random_key + 56, 8);
        strcpy(plaintext, secret);
        /* Encrypt the data */
        if (gcry_cipher_encrypt(hd, crypted, sizeof(crypted)-1, plaintext, sizeof(plaintext))) {
            printf("Failed to encrypt\n");
            gcry_cipher_close(hd);
            free(random_key);
            return -1;
        }
        fprintf(stdout, "Encryption key: %s\n", gcry_md_algo_name(GCRY_MD_SHA256));
        /* Now decryption */
        err = gcry_cipher_decrypt(hd, recoveredtext, sizeof(recoveredtext)-1, crypted, sizeof(crypted));
        if (err) {
            printf("Failed to decrypt\n");
            gcry_cipher_close(hd);
            free(random_key);
            return -1;
        }
        gcry_cipher_close(hd);
        free(random_key);
        printf("Recovered text: %s\n", recoveredtext);
    }
    return 0;
}