HMODULE hModule = LoadLibrary(_T("path\\to\\your\\library.dll"));\n   if (hModule) {\n       typedef HRESULT (__stdcall *DllRegisterServer)();\n       DllRegisterServer pfnDllRegisterServer =\n           (DllRegisterServer)GetProcAddress(hModule, _T("DllRegisterServer"));\n       if (pfnDllRegisterServer) {\n           pfnDllRegisterServer();\n       }\n       FreeLibrary(hModule);\n   }