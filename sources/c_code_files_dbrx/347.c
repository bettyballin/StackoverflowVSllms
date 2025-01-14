#include <windows.h>
#include <security.h>

int main() {
    // Name of the service you want to change its attributes
    char szSvcName[256] = "YourService";
    // User name and password used for starting, stopping or querying a specific service
    char* pszUserName = NULL;
    CHAR password[50]; // Change this accordingly!
    SECURITY_ATTRIBUTES sa;
    PACL pACL = NULL;
    PACL pOldDacl = NULL;
    PACL pNewDacl = NULL;
    PSECURITY_DESCRIPTOR sd = NULL;
    BOOL bDaclExist = FALSE;
    BOOL bDaclDefaulted = FALSE;

    // Initialize security descriptor.
    sd = (PSECURITY_DESCRIPTOR)LocalAlloc(LPTR, SECURITY_DESCRIPTOR_MIN_LENGTH);
    if (sd == NULL) {
        // Handle error
        return 1;
    }

    InitializeSecurityDescriptor(sd, SECURITY_DESCRIPTOR_REVISION);
    GetSecurityInfo((PVOID)szSvcName, SE_SERVICE, DACL_SECURITY_INFORMATION, NULL, NULL, &pOldDacl, NULL, &bDaclDefaulted);
    // Reuse the existing ACL.
    if (bDaclExist == 0 || pOldDacl == NULL) {
        SetSecurityDescriptorDacl(sd, TRUE, NULL, FALSE); // Create a new ACL.
    } else {
        SetSecurityDescriptorDacl(sd, TRUE, pOldDacl, FALSE); // Use the existing DACL.
    }

    if (pszUserName) {
        EXPLICIT_ACCESS ea;
        ZeroMemory(&ea, sizeof(EXPLICIT_ACCESS));
        ea.grfAccessPermissions = SERVICE_START | DELETE | READ_CONTROL;
        ea.grfAccessMode = SET_ACCESS;
        ea.grfInheritance = NO_INHERITANCE;
        ea.Trustee.MultipleTrusteeOperation = NO_MULTIPLE_TRUSTEE;
        ea.Trustee.pMultipleTrustee = NULL;
        ea.Trustee.TrusteeForm = TRUSTEE_IS_NAME;
        ea.Trustee.ptstrName = (LPWSTR)pszUserName;
        // Convert the ACLs.
        BuildExplicitAccessWithName(&ea, L"user", DOMAIN_ALIAS_RID_USERS, GENERIC_ALL);
        if (SetEntriesInAcl(1, &ea, pOldDacl, &pNewDacl) != ERROR_SUCCESS) {
            // Handle error
            return 1;
        }
    }

    if (SetSecurityInfo((PVOID)szSvcName, SE_SERVICE, DACL_SECURITY_INFORMATION | ACL_REVISION2, NULL, NULL, pNewDacl, NULL) != ERROR_SUCCESS) {
        // Handle error
        return 1;
    }

    if (pOldDacl) {
        LocalFree(pOldDacl);
    }
    if (pNewDacl) {
        LocalFree(pNewDacl);
    }
    LocalFree(sd);

    return 0;
}