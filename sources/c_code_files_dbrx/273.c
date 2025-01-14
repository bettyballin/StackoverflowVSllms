#include <stdio.h>
#include <oci.h>

int main() {
    OCIEnv *env;
    OCISvcCtx *svc;
    OCIError *err;
    OCISession *sess;
    OCIStmt *stmt;
    sb4 numRowsAffected;

    // Initialize the OCI environment
    if (OCIEnvCreate(&env, OCI_DEFAULT, 0, 0, 0, 0, 0, 0)) {
        printf("Failed to create OCI environment\n");
        return 1;
    }

    // Initialize the error handle
    if (OCIHandleAlloc(env, (dvoid **)&err, OCI_HTYPE_ERROR, 0, 0)) {
        printf("Failed to allocate error handle\n");
        return 1;
    }

    // Initialize the statement handle
    if (OCIHandleAlloc(env, (dvoid **)&stmt, OCI_HTYPE_STMT, 0, 0)) {
        printf("Failed to allocate statement handle\n");
        return 1;
    }

    // Assume that the statement has been executed and we want to get the row count
    OCIAttrGet(stmt, OCI_HTYPE_STMT, &numRowsAffected, 0, OCI_ATTR_ROW_COUNT, err);

    printf("Number of rows updated: %d\n", numRowsAffected);

    // Clean up
    OCIHandleFree(stmt, OCI_HTYPE_STMT);
    OCIHandleFree(err, OCI_HTYPE_ERROR);
    OCIEnvFree(env, OCI_DEFAULT);

    return 0;
}