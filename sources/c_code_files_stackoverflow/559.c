#include <Windows.h>
#include <stdio.h>

int main() {
    const char* sourceFile = "*.*";
    const char* destFile = "X:\\files.zip";

    DWORD copyFlags = COPY_FILE_FAIL_IF_EXISTS | COPY_FILE_RESTARTABLE;
    while (CopyFileExA(sourceFile, destFile, NULL, NULL, NULL, copyFlags) == 0) {
        do {
            // optionally, increment a failed counter to break out at some point
            Sleep(1000);
        } while (!IsNetworkAlive(NETWORK_ALIVE_LAN));
    }
    return 0;
}