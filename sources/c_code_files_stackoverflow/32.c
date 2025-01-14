#include <windows.h>
#include <stdio.h>

int main() {
    DWORD verHandle = 0;
    UINT size = 0;
    LPBYTE lpBuffer = NULL;
    char szVersionFile[] = "path_to_your_file.exe"; // replace with your file path
    DWORD verSize = GetFileVersionInfoSize(szVersionFile, &verHandle);

    if (verSize != 0) {
        LPVOID verData = malloc(verSize);

        if (GetFileVersionInfo(szVersionFile, verHandle, verSize, verData)) {
            if (VerQueryValue(verData, "\\", (LPVOID*)&lpBuffer, &size)) {
                if (size) {
                    VS_FIXEDFILEINFO* verInfo = (VS_FIXEDFILEINFO*)lpBuffer;
                    if (verInfo->dwSignature == 0xfeef04bd) {
                        printf("File Version: %d.%d.%d.%d\n",
                            (verInfo->dwFileVersionMS >> 16) & 0xffff,
                            (verInfo->dwFileVersionMS >> 0) & 0xffff,
                            (verInfo->dwFileVersionLS >> 16) & 0xffff,
                            (verInfo->dwFileVersionLS >> 0) & 0xffff);
                    }
                }
            }
        }
        free(verData);
    }

    return 0;
}