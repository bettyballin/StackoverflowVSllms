#include <windows.h>\n#include <objbase.h>\n\nextern "C" __declspec(dllexport) void GetStrings(BSTR* strings, int* count) {\n    const char* cStrings[] = {"Hello", "World"};\n    *count = sizeof(cStrings) / sizeof(cStrings[0]);\n\n    for (int i = 0; i < *count; ++i) {\n        // Convert C string to BSTR\n        strings[i] = SysAllocStringByteLen((LPSTR)cStrings[i], strlen(cStrings[i]));\n    }\n}\n\nextern "C" __declspec(dllexport) void FreeBSTRStrings(BSTR* strings, int count) {\n    for (int i = 0; i < count; ++i) {\n        // Free BSTR string\n        SysFreeString(strings[i]);\n    }\n}