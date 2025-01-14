#include <oci.h>

int main() {
    OCIEnv *envhp;
    OCISession *authp;
    OCIError *errhp;
    OCIStmt *stmthp;
    ub4 FETCH_SIZE = 100; // Define FETCH_SIZE

    // Initialize the OCI environment
    OCIEnvCreate(&envhp, OCI_DEFAULT, NULL, NULL, NULL, NULL, 0, NULL);

    // Initialize the error handle
    OCIHandleAlloc(envhp, (dvoid **)&errhp, OCI_HTYPE_ERROR, 0, NULL);

    // Initialize the statement handle
    OCIHandleAlloc(envhp, (dvoid **)&stmthp, OCI_HTYPE_STMT, 0, NULL);

    // Set the prefetch rows attribute
    OCIAttrSet(stmthp, OCI_HTYPE_STMT, (void *)&FETCH_SIZE, 0, OCI_ATTR_PREFETCH_ROWS, errhp);

    // Clean up
    OCIHandleFree(stmthp, OCI_HTYPE_STMT);
    OCIHandleFree(errhp, OCI_HTYPE_ERROR);
    OCIHandleFree(envhp, OCI_HTYPE_ENV);

    return 0;
}