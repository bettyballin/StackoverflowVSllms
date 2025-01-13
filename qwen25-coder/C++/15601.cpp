// Compile DLL with embedding manifest (using Visual Studio flags as an example)\ncl /clr /LD /clrmanifest dllcode.cpp\n\n// Loader code modification to print error details\n#include <windows.h>\n#include <iostream>\n\nint main()\n{\n    HINSTANCE lib = LoadLibraryA("dllcode.dll");\n    if (!lib) {\n        DWORD err = GetLastError();\n        std::cerr << "Failed to load DLL: Error Code=" << err << "\n";\n        return 1;\n    }\n    FreeLibrary(lib);\n    return 0;\n}