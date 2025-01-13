#ifndef _WIN32_WINNT\n#define _WIN32_WINNT 0x0501\n#endif\n#include <stdio.h>\n#include <tchar.h>\n#include <Windows.h>\n\nvoid xor_encrypt_decrypt(_TCHAR* str, _TCHAR key) {\n    while(*str) {\n        *str ^= key;\n        str++;\n    }\n}\n\nint _tmain(int argc, _TCHAR* argv[])\n{\n    _TCHAR hiddenString1[] = {_T('A') ^ 0xAA, _T('B') ^ 0xAA, _T('C') ^ 0xAA, 0}; // Encrypted string "ABC"\n    _TCHAR hiddenString2[] = {_T('X') ^ 0xAA, _T('Y') ^ 0xAA, _T('Z') ^ 0xAA, 0}; // Encrypted string "XYZ"\n    \n    xor_encrypt_decrypt(hiddenString1, 0xAA); // Decrypting at runtime\n    xor_encrypt_decrypt(hiddenString2, 0xAA); // Decrypting at runtime\n\n    for (int i= 0; i<argc; i++) {\n        if (0 == _tcscmp(argv[i], hiddenString1)) {\n            _tprintf (_T("The guid argument is correct.\n"));\n        } else if (0 == _tcscmp(argv[i], hiddenString2)) {\n            _tprintf (_T("Do something here.\n"));\n        }\n    }\n\n    _tprintf (_T("This is a visible string.\n"));\n    //Keep Running\n    Sleep(60000);\n    return 0;\n}