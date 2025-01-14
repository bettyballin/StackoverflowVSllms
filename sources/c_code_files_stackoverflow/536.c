#include <windows.h>
#include <wincrypt.h>

int main() {
    DATA_BLOB blobIn, blobOut;
    LPCWSTR data = L"your_data_here"; // replace with your data
    LPCWSTR description = L"your_description_here"; // replace with your description
    BYTE* _encrypted;
    DWORD _length;

    blobIn.pbData = (BYTE*)data;
    blobIn.cbData = wcslen(data) * sizeof(WCHAR);

    if (!CryptProtectData(&blobIn, description, NULL, NULL, NULL, CRYPTPROTECT_LOCAL_MACHINE | CRYPTPROTECT_UI_FORBIDDEN, &blobOut)) {
        // handle error
        return 1;
    }

    _encrypted = blobOut.pbData;
    _length = blobOut.cbData;

    // don't forget to free the memory
    LocalFree(blobOut.pbData);

    return 0;
}