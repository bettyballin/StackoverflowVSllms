#include <stdio.h>
#include <oci.h>

int main() {
    OCIEnv        *envhp;
    OCIError      *errhp;
    OCISvcCtx     *svchp;
    OCIStmt       *stmthp;

    // Initialize handles
    OCIEnvCreate(&envhp, OCI_DEFAULT, NULL, NULL, NULL, NULL, 0, NULL);
    OCIHandleAlloc(envhp, (dvoid **)&errhp, OCI_HTYPE_ERROR, 0, NULL);
    OCIHandleAlloc(envhp, (dvoid **)&svchp, OCI_HTYPE_SVCCTX, 0, NULL);
    OCIHandleAlloc(envhp, (dvoid **)&stmthp, OCI_HTYPE_STMT, 0, NULL);

    // Your original code for freeing handles
    OCIHandleFree(stmthp, OCI_HTYPE_STMT);
    OCIHandleFree(svchp, OCI_HTYPE_SVCCTX);
    OCIHandleFree(errhp, OCI_HTYPE_ERROR);
    OCIHandleFree(envhp, OCI_HTYPE_ENV);

    return 0;
}