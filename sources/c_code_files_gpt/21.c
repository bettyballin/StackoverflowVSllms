#include <windows.h>
#include <wincrypt.h>
#include <stdio.h>

void PrintHash(BYTE* hash, DWORD length) {
    for (DWORD i = 0; i < length; i++) {
        printf("%02x", hash[i]);
    }
    printf("\n");
}

int main() {
    HCRYPTPROV hProv = 0;
    HCRYPTHASH hHash = 0;
    BYTE hash[16]; // MD5 produces a 16-byte hash
    DWORD hashLen = 16;
    const char* data = "example string";

    // Acquire a cryptographic provider context handle
    if (CryptAcquireContext(&hProv, NULL, NULL, PROV_RSA_FULL, CRYPT_VERIFYCONTEXT)) {
        // Create the hash object
        if (CryptCreateHash(hProv, CALG_MD5, 0, 0, &hHash)) {
            // Hash the data
            if (CryptHashData(hHash, (BYTE*)data, strlen(data), 0)) {
                // Retrieve the hash value
                if (CryptGetHashParam(hHash, HP_HASHVAL, hash, &hashLen, 0)) {
                    printf("MD5 hash: ");
                    PrintHash(hash, hashLen);
                }
            }
            CryptDestroyHash(hHash);
        }
        CryptReleaseContext(hProv, 0);
    } else {
        printf("Error acquiring cryptographic context\n");
    }

    return 0;
}