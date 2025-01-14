#include <oci.h>

void set_query_timeout(OCIStmt *stmt, int timeout_ms) {
    OCIAttrSet(stmt, OCI_HTYPE_STMT, &timeout_ms, sizeof(timeout_ms), OCI_ATTR_CALL_TIMEOUT, NULL);
}

int main() {
    OCIStmt *stmt;
    OCIHandle *svc;
    OCIError *err;

    // Initialize the OCI environment
    OCIEnv *env;
    OCISession *sess;
    OCIEnvCreate(&env, OCI_DEFAULT, NULL, NULL, NULL, NULL, 0, NULL);

    // Initialize the OCI service context
    OCIHandleAlloc(env, (dvoid **)&svc, OCI_HTYPE_SVCCTX, 0, NULL);
    OCIHandleAlloc(env, (dvoid **)&err, OCI_HTYPE_ERROR, 0, NULL);
    OCIHandleAlloc(env, (dvoid **)&stmt, OCI_HTYPE_STMT, 0, NULL);

    // Assume stmt has been properly initialized
    int timeout_ms = 5000; // 5 seconds timeout
    set_query_timeout(stmt, timeout_ms);

    sword status = OCIStmtExecute(svc, stmt, err, 1, 0, NULL, NULL, OCI_DEFAULT);
    if (status == OCI_SUCCESS) {
        // Query executed successfully
    } else if (status == OCI_STILL_EXECUTING) {
        // Handle timeout
    } else {
        // Handle other errors
    }

    // Clean up
    OCIHandleFree(stmt, OCI_HTYPE_STMT);
    OCIHandleFree(err, OCI_HTYPE_ERROR);
    OCIHandleFree(svc, OCI_HTYPE_SVCCTX);
    OCIHandleFree(env, OCI_HTYPE_ENV);

    return 0;
}