#include <windows.h>\n#include <objbase.h>\n\nHRESULT GetStringLength(BSTR bstrInput, DWORD *pdwLength) {\n    if (!bstrInput || !pdwLength)\n        return E_POINTER;\n\n    // Calculate the length of the BSTR (excluding the null terminator).\n    *pdwLength = SysStringLen(bstrInput); \n\n    // Allocate memory for a copy of the integer.\n    DWORD* pLength = (DWORD*)CoTaskMemAlloc(sizeof(DWORD));\n    if (!pLength)\n        return E_OUTOFMEMORY;\n\n    // Copy the length into the allocated memory.\n    *pLength = *pdwLength;\n\n    // Assign the pointer to the output parameter.\n    *pdwLength = reinterpret_cast<DWORD>(pLength);\n    return S_OK;\n}\n\n// Remember to free the memory using CoTaskMemFree after use:\n// DWORD* pLength = (DWORD*)dwLength;\n// CoTaskMemFree(pLength);