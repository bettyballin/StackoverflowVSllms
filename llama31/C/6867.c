BOOL WINAPI GetExtensionVersion(HSE_VERSION_INFO* pVer)\n{\n    // Return the version information\n    pVer->dwExtensionVersion = MAKELONG(1, 0);\n    return TRUE;\n}