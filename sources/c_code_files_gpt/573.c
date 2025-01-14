#include <windows.h>
#include <aclapi.h>
#include <sddl.h>

void SetFolderPermissions(const char* folderPath)
{
    // Define the security descriptor string for granting write permissions to the Users group
    const char* securityDescriptorString = "D:(A;OICI;GW;;;BU)";

    // Convert the security descriptor string to a SECURITY_DESCRIPTOR
    PSECURITY_DESCRIPTOR pSD = NULL;
    if (!ConvertStringSecurityDescriptorToSecurityDescriptorA(securityDescriptorString, SDDL_REVISION_1, &pSD, NULL))
    {
        printf("ConvertStringSecurityDescriptorToSecurityDescriptorA failed. Error: %lu\n", GetLastError());
        return;
    }

    // Set the security information of the folder
    DWORD result = SetNamedSecurityInfoA(
        const_cast<char*>(folderPath),      // The name of the object
        SE_FILE_OBJECT,                    // The type of object
        DACL_SECURITY_INFORMATION,         // The information to set
        NULL,                              // The owner SID
        NULL,                              // The primary group SID
        NULL,                              // The DACL
        NULL                               // The SACL
    );

    if (result != ERROR_SUCCESS)
    {
        printf("SetNamedSecurityInfoA failed. Error: %lu\n", result);
    }

    // Clean up
    LocalFree(pSD);
}

int main()
{
    const char* folderPath = "C:\\ProgramData\\Company\\Product"; // Path to the folder
    SetFolderPermissions(folderPath);
    return 0;
}