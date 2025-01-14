#include <oci.h>

#define FETCH_SIZE 1000

int main() {
    int intArray[FETCH_SIZE];
    sb2 indicators[FETCH_SIZE];
    ub2 rlen[FETCH_SIZE];
    ub2 rcode[FETCH_SIZE];

    OCIEnv *envhp;
    OCIError *errhp;
    OCISvcCtx *svchp;
    OCIStmt *stmthp;
    OCIDefine *defnp;

    // Initialize the OCI environment
    OCIEnvCreate((OCIEnv **)&envhp, OCI_DEFAULT, (dvoid *)0, 0, 0, 0, (size_t)0, (dvoid *)0);

    // Initialize the error handle
    OCIHandleAlloc(envhp, (dvoid **)&errhp, OCI_HTYPE_ERROR, 0, (dvoid *)0);

    // Initialize the service context handle
    OCIHandleAlloc(envhp, (dvoid **)&svchp, OCI_HTYPE_SVCCTX, 0, (dvoid *)0);

    // Initialize the statement handle
    OCIHandleAlloc(envhp, (dvoid **)&stmthp, OCI_HTYPE_STMT, 0, (dvoid *)0);

    // Define the output variables
    OCIDefineByPos(stmthp, &defnp, errhp, 1, (dvoid *)intArray, sizeof(int), SQLT_INT, (dvoid *)indicators, (ub2 *)rlen, (ub2 *)rcode, OCI_DEFAULT);

    // Release resources
    OCIHandleFree(stmthp, OCI_HTYPE_STMT);
    OCIHandleFree(svchp, OCI_HTYPE_SVCCTX);
    OCIHandleFree(errhp, OCI_HTYPE_ERROR);
    OCIHandleFree(envhp, OCI_HTYPE_ENV);

    return 0;
}