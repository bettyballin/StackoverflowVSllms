extern "C" BOOL WINAPI DllMain(HINSTANCE hInstance, \n                               DWORD dwReason, \n                               LPVOID lpReserved)\n{\n    hInstance;\n    m_hInstance = hInstance;\n\n    if (dwReason == DLL_PROCESS_ATTACH) {\n        // Initialize ATL module here\n        _AtlModule.Initialize();\n    }\n\n    return TRUE;\n}