#include <stdio.h>
#include <oci.h>

int main() {
    OCIEnv* env;
    OCISvcCtx* svc;
    OCIError* err;
    OCIStmt* stmt;
    OCIDefine* def;
    OCIBind* bnd;
    char username[32] = "username";
    char password[32] = "password";
    char database[32] = "database_name";
    char query[64] = "SELECT * FROM table_name";

    // Initialize the environment
    if (OCIEnvCreate(&env, OCI_DEFAULT, 0, 0, 0, 0, 0, 0)) {
        printf("OCIEnvCreate failed\n");
        return 1;
    }

    // Create the error handle
    if (OCIHandleAlloc(env, (dvoid**)&err, OCI_HTYPE_ERROR, 0, 0)) {
        printf("OCIHandleAlloc failed\n");
        return 1;
    }

    // Create the server context
    if (OCILogon(env, err, &svc, username, strlen(username), password, strlen(password), database, strlen(database))) {
        printf("OCILogon failed\n");
        return 1;
    }

    // Allocate the statement handle
    if (OCIHandleAlloc(env, (dvoid**)&stmt, OCI_HTYPE_STMT, 0, 0)) {
        printf("OCIHandleAlloc failed\n");
        return 1;
    }

    // Prepare the query
    if (OCIStmtPrepare(stmt, err, query, strlen(query), OCI_NTV_SYNTAX, OCI_DEFAULT)) {
        printf("OCIStmtPrepare failed\n");
        return 1;
    }

    // Execute the query
    if (OCIStmtExecute(svc, stmt, err, 1, 0, 0, 0, OCI_DEFAULT)) {
        printf("OCIStmtExecute failed\n");
        return 1;
    }

    // Fetch the data
    while (1) {
        if (OCIStmtFetch(stmt, err, 1, OCI_FETCH_NEXT, OCI_DEFAULT)) {
            printf("OCIStmtFetch failed\n");
            break;
        }
        // Process your data here
    }

    // Release the resources
    if (OCIStmtRelease(stmt, err, 0, 0, OCI_DEFAULT)) {
        printf("OCIStmtRelease failed\n");
        return 1;
    }

    if (OCILogoff(svc, err)) {
        printf("OCILogoff failed\n");
        return 1;
    }

    if (OCIHandleFree(err, OCI_HTYPE_ERROR)) {
        printf("OCIHandleFree failed\n");
        return 1;
    }

    if (OCIHandleFree(env, OCI_HTYPE_ENV)) {
        printf("OCIHandleFree failed\n");
        return 1;
    }

    return 0;
}