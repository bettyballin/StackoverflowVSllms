#include <windows.h>\n#include <httpfilt.h>\n#include <httpext.h>\n\nBOOL WINAPI GetExtensionVersion(HSE_VERSION_INFO *pVer)\n{\n    pVer->dwExtensionVersion = MAKELONG(1,0);\n    strcpy(pVer->lpszExtensionDesc, "Simple ISAPI Extension");\n    return TRUE;\n}\n\nDWORD WINAPI HttpExtensionProc(EXTENSION_CONTROL_BLOCK *pECB)\n{\n    const char* szText = "Hello, ISAPI!";\n    DWORD dwSize = (DWORD)strlen(szText);\n\n    pECB->ServerSupportFunction(pECB->ConnID, HSE_REQ_SEND_RESPONSE_HEADER, "200 OK", NULL, NULL);\n\n    pECB->WriteClient(pECB->ConnID, (LPVOID)szText, &dwSize, 0);\n\n    return HSE_STATUS_SUCCESS;\n}\n\nBOOL WINAPI TerminateExtension(DWORD dwFlags)\n{\n    return TRUE;\n}