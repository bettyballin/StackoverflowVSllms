#include <windows.h>\n#include <Aclapi.h>\n#include <sddl.h>\n#include <tchar.h>\n#include <iostream>\n\nbool CheckDirectoryWritePermission(LPCTSTR directoryPath)\n{\n    PSECURITY_DESCRIPTOR pSD = NULL;\n    PSID pSid = NULL;\n    HANDLE hToken = NULL;\n    DWORD dwAccessDesired = GENERIC_WRITE;\n    DWORD dwAccessGranted = 0;\n    DWORD dwSize = 0;\n    BOOL bAccessStatus = FALSE;\n    PRIVILEGE_SET PrivilegeSet;\n    DWORD PrivilegeSetLength = sizeof(PRIVILEGE_SET);\n\n    // Get the security descriptor for the directory\n    if (!GetFileSecurity(directoryPath, OWNER_SECURITY_INFORMATION | GROUP_SECURITY_INFORMATION | DACL_SECURITY_INFORMATION, NULL, 0, &dwSize) &&\n        GetLastError() == ERROR_INSUFFICIENT_BUFFER)\n    {\n        pSD = (PSECURITY_DESCRIPTOR)HeapAlloc(GetProcessHeap(), HEAP_ZERO_MEMORY, dwSize);\n        if (pSD == NULL)\n        {\n            std::cerr << "HeapAlloc failed" << std::endl;\n            return false;\n        }\n\n        if (!GetFileSecurity(directoryPath, OWNER_SECURITY_INFORMATION | GROUP_SECURITY_INFORMATION | DACL_SECURITY_INFORMATION, pSD, dwSize, &dwSize))\n        {\n            std::cerr << "GetFileSecurity failed" << std::endl;\n            HeapFree(GetProcessHeap(), 0, pSD);\n            return false;\n        }\n    }\n    else\n    {\n        std::cerr << "GetFileSecurity failed to retrieve size" << std::endl;\n        return false;\n    }\n\n    // Get the current process token\n    if (!OpenProcessToken(GetCurrentProcess(), TOKEN_QUERY, &hToken))\n    {\n        std::cerr << "OpenProcessToken failed" << std::endl;\n        HeapFree(GetProcessHeap(), 0, pSD);\n        return false;\n    }\n\n    // Check access rights\n    if (!AccessCheck(pSD, hToken, dwAccessDesired, &GENERIC_MAPPING, &PrivilegeSet, &PrivilegeSetLength, &dwAccessGranted, &bAccessStatus))\n    {\n        std::cerr << "AccessCheck failed" << std::endl;\n        HeapFree(GetProcessHeap(), 0, pSD);\n        CloseHandle(hToken);\n        return false;\n    }\n\n    HeapFree(GetProcessHeap(), 0, pSD);\n    CloseHandle(hToken);\n\n    return bAccessStatus && (dwAccessGranted & dwAccessDesired);\n}\n\nint main()\n{\n    if (CheckDirectoryWritePermission(_T("C:\\mydir")))\n    {\n        std::cout << "Directory is writable." << std::endl;\n    }\n    else\n    {\n        std::cout << "Directory is not writable." << std::endl;\n    }\n\n    return 0;\n}