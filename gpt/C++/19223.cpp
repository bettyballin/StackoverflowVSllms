#include <windows.h>\n   #include <shlobj.h>\n   #include <knownfolders.h>\n   #include <tchar.h>\n\n   PWSTR path = NULL;\n   if (SUCCEEDED(SHGetKnownFolderPath(FOLDERID_RoamingAppData, 0, NULL, &path))) {\n       // Convert the wide string to TCHAR if needed\n       // Creating your application-specific folder\n       PathAppend(path, L"MyProgram");\n       CreateDirectory(path, NULL);\n       // Use this path to store your INI files\n       CoTaskMemFree(path);\n   }