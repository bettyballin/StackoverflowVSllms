#include <windows.h>
#include <wincrypt.h>

int main() {
    // Initialize the provider handle.
    HCRYPTPROV hCryptProv;
    if(CryptAcquireContext(&hCryptProv, NULL, MS_ENHANCED_PROV, PROV_RSA_FULL, CRYPT_VERIFYCONTEXT)) {
        // Do operations with the provider.
        // ...
        CryptReleaseContext(hCryptProv, 0);
    }
    return 0;
}