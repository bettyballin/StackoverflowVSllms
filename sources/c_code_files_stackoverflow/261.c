pp
#include <windows.h>
#include <aclapi.h>
#include <atlsecurity.h>
#include <atlbase.h>

int main() {
    // Initialize COM
    CoInitialize(NULL);

    CDacl oDacl;
    CString strFolder = "C:\\Path\\To\\Folder"; // replace with the desired folder path

    AtlGetDacl(strFolder, SE_FILE_OBJECT, &oDacl);
    oDacl.RemoveAces(Sids::Users()); // Remove existing "Users" access
    oDacl.AddAllowedAce(Sids::Users(), FILE_ALL_ACCESS, CONTAINER_INHERIT_ACE | OBJECT_INHERIT_ACE);
    AtlSetDacl(strFolder, SE_FILE_OBJECT, oDacl);

    // Uninitialize COM
    CoUninitialize();

    return 0;
}