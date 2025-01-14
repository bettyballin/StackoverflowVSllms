#include <stdio.h>
#include <string.h>
#include <oci.h>

int main() {
    OCIEnv* env;
    OCISvcCtx* svc;
    OCIError* err;
    OCIStmt* stmt;
    OCIDefine* def;
    char date_str[20];

    // Initialize OCI environment
    if (OCIEnvCreate(&env, OCI_DEFAULT, NULL, NULL, NULL, NULL, 0, NULL)) {
        printf("Failed to initialize OCI environment\n");
        return 1;
    }

    // Create error handle
    if (OCIHandleAlloc(env, (dvoid**)&err, OCI_HTYPE_ERROR, 0, NULL)) {
        printf("Failed to allocate error handle\n");
        return 1;
    }

    // Create server context
    if (OCIHandleAlloc(env, (dvoid**)&svc, OCI_HTYPE_SVCCTX, 0, NULL)) {
        printf("Failed to allocate server context\n");
        return 1;
    }

    // Attach to the server
    if (OCILogon(env, err, &svc, (OraText*) "your_username", strlen("your_username"),
                 (OraText*) "your_password", strlen("your_password"),
                 (OraText*) "your_database", strlen("your_database"))) {
        printf("Failed to logon to the database\n");
        return 1;
    }

    // Create statement handle
    if (OCIHandleAlloc(env, (dvoid**)&stmt, OCI_HTYPE_STMT, 0, NULL)) {
        printf("Failed to allocate statement handle\n");
        return 1;
    }

    // Prepare the SQL statement
    if (OCIStmtPrepare(stmt, err, (OraText*) "SELECT TO_CHAR(your_date_column, 'YYYY-MM-DD') FROM your_table",
                      strlen("SELECT TO_CHAR(your_date_column, 'YYYY-MM-DD') FROM your_table"),
                      OCI_NTV_SYNTAX, OCI_DEFAULT)) {
        printf("Failed to prepare SQL statement\n");
        return 1;
    }

    // Define the output variable
    if (OCIDefineByPos(stmt, &def, err, 1, date_str, 20, SQLT_STR, NULL, NULL, NULL, OCI_DEFAULT)) {
        printf("Failed to define output variable\n");
        return 1;
    }

    // Execute the SQL statement
    if (OCIStmtExecute(svc, stmt, err, 1, 0, NULL, NULL, OCI_DEFAULT)) {
        printf("Failed to execute SQL statement\n");
        return 1;
    }

    // Fetch the result
    if (OCIStmtFetch(stmt, err, 1, OCI_FETCH_NEXT, OCI_DEFAULT)) {
        printf("Failed to fetch result\n");
        return 1;
    }

    printf("Date: %s\n", date_str);

    // Clean up
    OCILogoff(svc, err);
    OCIHandleFree(stmt, OCI_HTYPE_STMT);
    OCIHandleFree(svc, OCI_HTYPE_SVCCTX);
    OCIHandleFree(err, OCI_HTYPE_ERROR);
    OCIHandleFree(env, OCI_HTYPE_ENV);

    return 0;
}