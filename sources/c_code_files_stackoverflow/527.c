#include <Windows.h>
#include <msi.h>

int main() {
    MSIHANDLE hInstaller;
    MSIHANDLE hDB;
    DWORD err = MsiCreateInstallerHandleA(NULL, &hInstaller);
    if (err != ERROR_SUCCESS) {
        return 1;
    }

    err = MsiOpenDatabaseW(hInstaller, L"c:\\foo\\bar.msi", MSI_OPEN_DATABASE_MODE_TRANSACT, &hDB);
    if (err != ERROR_SUCCESS) {
        MsiCloseHandle(hInstaller);
        return 1;
    }

    // Use the hDB handle as needed...

    MsiCloseHandle(hDB);
    MsiCloseHandle(hInstaller);
    return 0;
}