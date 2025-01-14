#include <Windows.h>
#include <ShlObj.h>
#include <tchar.h>

int main() {
    TCHAR path[MAX_PATH];
    if (SUCCEEDED(SHGetFolderPath(NULL, CSIDL_APPDATA, NULL, 0, path))) {
        // Create your application-specific folder if it doesn't exist
        _tcscat(path, _T("\\MyProgram"));
        CreateDirectory(path, NULL);
        // Use this path to store your INI files
    }
    return 0;
}