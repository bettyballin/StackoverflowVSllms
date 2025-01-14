#include <stdio.h>
#include <oci.h>

#define FETCH_SIZE 10 // Define the fetch size

int main() {
    OCIEnv *envhp;
    OCISvcCtx *svchp;
    OCIError *errhp;
    OCIStmt *stmthp;
    sword status;
    int intArray[FETCH_SIZE];
    sb2 indicators[FETCH_SIZE];

    // Initialize the OCI environment
    if (OCIEnvCreate((OCIEnv **)&envhp, OCI_DEFAULT, NULL, NULL, NULL, NULL, 0, NULL)) {
        printf("Failed to create OCI environment\n");
        return 1;
    }

    // Initialize the OCI error handle
    if (OCIHandleAlloc(envhp, (dvoid **)&errhp, OCI_HTYPE_ERROR, 0, NULL)) {
        printf("Failed to allocate OCI error handle\n");
        return 1;
    }

    // Assume svchp and stmthp are already initialized

    status = OCIStmtExecute(svchp, stmthp, errhp, 0, 0, NULL, NULL, OCI_DEFAULT);

    while ((status = OCIStmtFetch2(stmthp, errhp, FETCH_SIZE, OCI_FETCH_NEXT, 1, OCI_DEFAULT)) == OCI_SUCCESS || status == OCI_SUCCESS_WITH_INFO) {
        for (int i = 0; i < FETCH_SIZE; i++) {
            if (indicators[i] != -1) { // Check for NULL values
                printf("Fetched integer: %d\n", intArray[i]);
            }
        }
    }

    if (status != OCI_NO_DATA) {
        // Handle error
        text errbuf[512];
        sb4 errcode;
        OCIErrorGet((dvoid *)errhp, (ub4)1, (text *)NULL, &errcode, errbuf, (ub4)sizeof(errbuf), OCI_HTYPE_ERROR);
        printf("Error - %.*s\n", 512, errbuf);
    }

    // Clean up
    OCIHandleFree(errhp, OCI_HTYPE_ERROR);
    OCIHandleFree(envhp, OCI_HTYPE_ENV);

    return 0;
}