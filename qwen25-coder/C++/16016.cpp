#include <windows.h>\n#include <wincrypt.h>\n#include <iostream>\n\n#pragma comment(lib, "advapi32.lib")\n\nvoid MyHandleError(LPTSTR lpszFunction)\n{\n    // Replace with your error-handling code.\n    printf("%s failed with 0x%8x\n", lpszFunction, GetLastError());\n}\n\nint main()\n{\n    HCRYPTPROV hProv;\n    HCRYPTKEY hKey;\n    BYTE *pbData = (BYTE *)"SmallBlock";\n    DWORD dwDataLen = strlen((char *)pbData) + 1; // include the null character\n    BYTE pbEncrypted[512 / 8]; // size for a 512-bit encrypted block is 64 bytes\n    DWORD dwEncryptLen = sizeof(pbEncrypted);\n    HCRYPTHASH hHash;\n    bool status;\n\n    if (!CryptAcquireContext(&hProv,\n        NULL,                   // Use the default container.\n        MS_ENHANCED_PROV,\n        PROV_RSA_FULL,\n        CRYPT_VERIFYCONTEXT)) {\n        MyHandleError(L"CryptAcquireContext");\n        return 1;\n    }\n\n    // Assume hKey is your RSA public key\n    // This example does not include how to load or create the key.\n    // For demonstration, let's assume hKey is already obtained.\n\n    if (!CryptEncrypt(hKey,\n        0,\n        TRUE,                  // Final piece of data\n        0,\n        pbEncrypted,\n        &dwEncryptLen,\n        sizeof(pbEncrypted))) {\n        MyHandleError(L"CryptEncrypt");\n    }\n    else {\n        printf("Encryption succeeded.\n");\n        // Output encrypted bytes for verification\n        std::cout << "Encrypted data: ";\n        for (DWORD i = 0; i < dwEncryptLen; i++) {\n            printf("%02X", pbEncrypted[i]);\n        }\n        std::cout << std::endl;\n    }\n\n    if (hKey) CryptDestroyKey(hKey);\n    if (hProv) CryptReleaseContext(hProv, 0);\n\n    return 0;\n}