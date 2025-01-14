#include <Windows.h>
#include <Winver.h>

int main() {
    WCHAR fileName[_MAX_PATH];
    DWORD size = GetModuleFileName(NULL, fileName, _MAX_PATH);
    fileName[size] = L'\0'; // Correctly terminate the string

    DWORD handle = 0;
    size = GetFileVersionInfoSize(fileName, &handle);
    BYTE* versionInfo = (BYTE*) malloc(size);
    if (!GetFileVersionInfo(fileName, handle, size, versionInfo))
    {
        free(versionInfo);
        return 1; // Exit with an error code
    }
    // we have version information
    UINT                len = 0;
    VS_FIXEDFILEINFO*   vsfi = NULL;
    VerQueryValue(versionInfo, L"\\", (LPVOID*)&vsfi, &len);

    // Assuming aVersion is defined somewhere, for demonstration purposes
    // it's declared here as an array of WORDs.
    WORD aVersion[4];
    aVersion[0] = HIWORD(vsfi->dwFileVersionMS);
    aVersion[1] = LOWORD(vsfi->dwFileVersionMS);
    aVersion[2] = HIWORD(vsfi->dwFileVersionLS);
    aVersion[3] = LOWORD(vsfi->dwFileVersionLS);

    // Example: print the version
    wprintf(L"Version: %d.%d.%d.%d\n", aVersion[0], aVersion[1], aVersion[2], aVersion[3]);

    free(versionInfo);
    return 0;
}