#include <windows.h>\n#include <aclapi.h>\n#include <sddl.h>\n\nvoid SetFolderPermissions(const char* folderPath)\n{\n    // Define the security descriptor string for granting write permissions to the Users group\n    const char* securityDescriptorString = "D:(A;OICI;GW;;;BU)";\n\n    // Convert the security descriptor string to a SECURITY_DESCRIPTOR\n    PSECURITY_DESCRIPTOR pSD = NULL;\n    if (!ConvertStringSecurityDescriptorToSecurityDescriptorA(securityDescriptorString, SDDL_REVISION_1, &pSD, NULL))\n    {\n        printf("ConvertStringSecurityDescriptorToSecurityDescriptorA failed. Error: %lu\n", GetLastError());\n        return;\n    }\n\n    // Set the security information of the folder\n    DWORD result = SetNamedSecurityInfoA(\n        const_cast<char*>(folderPath),      // The name of the object\n        SE_FILE_OBJECT,                    // The type of object\n        DACL_SECURITY_INFORMATION,         // The information to set\n        NULL,                              // The owner SID\n        NULL,                              // The primary group SID\n        NULL,                              // The DACL\n        NULL                               // The SACL\n    );\n\n    if (result != ERROR_SUCCESS)\n    {\n        printf("SetNamedSecurityInfoA failed. Error: %lu\n", result);\n    }\n\n    // Clean up\n    LocalFree(pSD);\n}\n\nint main()\n{\n    const char* folderPath = "C:\\ProgramData\\Company\\Product"; // Path to the folder\n    SetFolderPermissions(folderPath);\n    return 0;\n}