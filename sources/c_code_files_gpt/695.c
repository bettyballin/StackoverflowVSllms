#include <oci.h>
#include <stdio.h>
#include <string.h>

int main() {
    OCIEnv *env;
    OCIError *err;
    OCISvcCtx *svc;
    OCIStmt *stmt;
    OCIBind *bnd1 = NULL, *bnd2 = NULL, *bnd3 = NULL;
    text *sql_stmt = (text *)"BEGIN :result := get_seq_number(:p_table_name, :p_seq_type); END;";
    text *p_table_name = (text *)"your_table_name";
    text *p_seq_type = (text *)"your_seq_type";
    int result;
    sword rc;

    /* Initialize OCI environment */
    rc = OCIEnvCreate((OCIEnv **)&env, OCI_DEFAULT, NULL, NULL, NULL, NULL, 0, NULL);
    if (rc != OCI_SUCCESS) {
        printf("Failed to create OCI environment\n");
        return 1;
    }

    /* Initialize error handle */
    rc = OCIHandleAlloc(env, (dvoid **)&err, OCI_HTYPE_ERROR, 0, NULL);
    if (rc != OCI_SUCCESS) {
        printf("Failed to allocate error handle\n");
        return 1;
    }

    /* Initialize service context */
    rc = OCIHandleAlloc(env, (dvoid **)&svc, OCI_HTYPE_SVCCTX, 0, NULL);
    if (rc != OCI_SUCCESS) {
        printf("Failed to allocate service context\n");
        return 1;
    }

    /* Initialize server handle */
    OCIServer *srv;
    rc = OCIHandleAlloc(env, (dvoid **)&srv, OCI_HTYPE_SERVER, 0, NULL);
    if (rc != OCI_SUCCESS) {
        printf("Failed to allocate server handle\n");
        return 1;
    }

    /* Attach to the server */
    rc = OCIServerAttach(srv, err, (text *)"your_database_url", strlen("your_database_url"), OCI_DEFAULT);
    if (rc != OCI_SUCCESS) {
        printf("Failed to attach to the server\n");
        return 1;
    }

    /* Initialize service context */
    rc = OCIAttrSet(svc, OCI_HTYPE_SVCCTX, srv, 0, OCI_ATTR_SERVER, err);
    if (rc != OCI_SUCCESS) {
        printf("Failed to set server attribute\n");
        return 1;
    }

    /* Prepare the SQL statement */
    rc = OCIHandleAlloc(env, (dvoid **)&stmt, OCI_HTYPE_STMT, 0, NULL);
    if (rc != OCI_SUCCESS) {
        printf("Failed to allocate statement handle\n");
        return 1;
    }

    rc = OCIStmtPrepare(stmt, err, sql_stmt, (ub4)strlen((char *)sql_stmt), OCI_NTV_SYNTAX, OCI_DEFAULT);
    if (rc != OCI_SUCCESS) {
        printf("Failed to prepare SQL statement\n");
        return 1;
    }

    /* Bind the input parameters */
    rc = OCIBindByName(stmt, &bnd1, err, (text *)":p_table_name", -1, (dvoid *)p_table_name, (sb4)strlen((char *)p_table_name) + 1, SQLT_STR, NULL, NULL, NULL, 0, NULL, OCI_DEFAULT);
    if (rc != OCI_SUCCESS) {
        printf("Failed to bind p_table_name\n");
        return 1;
    }

    rc = OCIBindByName(stmt, &bnd2, err, (text *)":p_seq_type", -1, (dvoid *)p_seq_type, (sb4)strlen((char *)p_seq_type) + 1, SQLT_STR, NULL, NULL, NULL, 0, NULL, OCI_DEFAULT);
    if (rc != OCI_SUCCESS) {
        printf("Failed to bind p_seq_type\n");
        return 1;
    }

    /* Bind the output parameter */
    rc = OCIBindByName(stmt, &bnd3, err, (text *)":result", -1, (dvoid *)&result, sizeof(result), SQLT_INT, NULL, NULL, NULL, 0, NULL, OCI_DEFAULT);
    if (rc != OCI_SUCCESS) {
        printf("Failed to bind result\n");
        return 1;
    }

    /* Execute the statement */
    rc = OCIStmtExecute(svc, stmt, err, 1, 0, NULL, NULL, OCI_DEFAULT);
    if (rc != OCI_SUCCESS) {
        printf("Failed to execute SQL statement\n");
        return 1;
    }

    /* result now contains the return value from the function */
    printf("Result: %d\n", result);

    /* Clean up OCI environment */
    OCIServerDetach(srv, err, OCI_DEFAULT);
    OCIHandleFree(srv, OCI_HTYPE_SERVER);
    OCIHandleFree(stmt, OCI_HTYPE_STMT);
    OCIHandleFree(svc, OCI_HTYPE_SVCCTX);
    OCIHandleFree(err, OCI_HTYPE_ERROR);
    OCIHandleFree(env, OCI_HTYPE_ENV);

    return 0;
}