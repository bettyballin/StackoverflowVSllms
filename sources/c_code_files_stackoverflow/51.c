#include <windows.h>
#include <wincrypt.h>

int main() {
    // Define BYTE if it's not already defined
    typedef unsigned char BYTE;

    // Define CRYPT_DATA_BLOB if it's not already defined
    typedef struct _CRYPTOAPI_BLOB {
        DWORD cbData;
        BYTE *pbData;
    } CRYPT_DATA_BLOB, *PCRYPT_DATA_BLOB;

    BYTE p[64] = { 139 }; // little-endian, all other bytes set to 0
    BYTE g[64] = { 5 };

    CRYPT_DATA_BLOB pblob;
    pblob.cbData = sizeof(p);
    pblob.pbData = p;

    CRYPT_DATA_BLOB gblob;
    gblob.cbData = sizeof(g);
    gblob.pbData = g;

    HCRYPTKEY hKey;
    HCRYPTPROV m_hCryptoProvider; // You need to obtain a crypto provider handle

    // Example to obtain a crypto provider handle
    if (!CryptAcquireContext(&m_hCryptoProvider, NULL, NULL, PROV_RSA_FULL, 0)) {
        // Handle error
        return 1;
    }

    if (::CryptGenKey(m_hCryptoProvider, CALG_DH_SF,
        (512 << 16) | CRYPT_PREGEN, &hKey)) {
        ::CryptSetKeyParam(hKey, KP_P, (LPBYTE)&pblob, 0);
    }

    // Don't forget to release the crypto provider handle when you're done
    CryptReleaseContext(m_hCryptoProvider, 0);

    return 0;
}