#include <Windows.h>
#include <stdio.h>
#include <stdlib.h>

// Function to create a DACL (Discretionary Access Control List)
BOOL CreateMyDACL(SECURITY_ATTRIBUTES *sa) {
    // TO DO: implement the CreateMyDACL function
    // For demonstration purposes, a placeholder DACL is created
    BYTE sd[SECURITY_DESCRIPTOR_MIN_LENGTH];
    InitializeSecurityDescriptor(sd, SECURITY_DESCRIPTOR_REVISION);
    SetSecurityDescriptorDacl(sd, TRUE, NULL, FALSE);
    sa->lpSecurityDescriptor = sd;
    return TRUE;
}

int main() {
    SECURITY_ATTRIBUTES sa;
    HKEY hKey;
    const char *subKey = "SOFTWARE\\MyKey";

    sa.nLength = sizeof(SECURITY_ATTRIBUTES);
    sa.bInheritHandle = FALSE;

    if (!CreateMyDACL(&sa)) {
        printf("Failed CreateMyDACL\n");
        exit(1);
    }

    LONG result = RegCreateKeyEx(HKEY_LOCAL_MACHINE, subKey, 0, NULL, 0, KEY_ALL_ACCESS, &sa, &hKey, NULL);

    if (result != ERROR_SUCCESS) {
        printf("Failed RegCreateKeyEx: %d\n", result);
        exit(1);
    }

    // Don't forget to close the registry key handle
    RegCloseKey(hKey);

    return 0;
}