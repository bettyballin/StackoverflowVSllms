#include <oci.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    // Assume you have already set up your OCI environment, server context, etc.
    OCIEnv    *env;
    OCISvcCtx *svcCtx;
    OCIError  *err;
    OCIStmt   *stmt;
    ub4 row_count;

    // Initialize OCI environment
    if (OCIEnvCreate((OCIEnv **)&env, OCI_DEFAULT, NULL, NULL, NULL, NULL, 0, NULL)) {
        fprintf(stderr, "Failed to create OCI environment\n");
        return 1;
    }

    // Initialize error handle
    if (OCIHandleAlloc(env, (dvoid **)&err, OCI_HTYPE_ERROR, 0, NULL)) {
        fprintf(stderr, "Failed to allocate OCI error handle\n");
        return 1;
    }

    // Initialize service context
    if (OCIHandleAlloc(env, (dvoid **)&svcCtx, OCI_HTYPE_SVCCTX, 0, NULL)) {
        fprintf(stderr, "Failed to allocate OCI service context\n");
        return 1;
    }

    // Initialize statement handle
    if (OCIHandleAlloc(env, (dvoid **)&stmt, OCI_HTYPE_STMT, 0, NULL)) {
        fprintf(stderr, "Failed to allocate OCI statement handle\n");
        return 1;
    }

    // Assume you have connected to the database and set up your server context, etc.
    // For brevity, the connection step is omitted here.

    // Execute your statement
    sword status = OCIStmtExecute(svcCtx, stmt, err, 1, 0, NULL, NULL, OCI_DEFAULT);
    if (status != OCI_SUCCESS) {
        // Handle error
        fprintf(stderr, "Failed to execute statement\n");
        return 1;
    }

    // Get the number of rows affected
    status = OCIAttrGet(stmt, OCI_HTYPE_STMT, &row_count, 0, OCI_ATTR_ROW_COUNT, err);
    if (status != OCI_SUCCESS) {
        // Handle error
        fprintf(stderr, "Failed to get row count\n");
        return 1;
    }

    printf("Number of rows updated: %u\n", row_count);

    // Cleanup and free OCI resources
    OCIHandleFree(stmt, OCI_HTYPE_STMT);
    OCIHandleFree(svcCtx, OCI_HTYPE_SVCCTX);
    OCIHandleFree(err, OCI_HTYPE_ERROR);
    OCIHandleFree(env, OCI_HTYPE_ENV);

    return 0;
}