#include <stdio.h>
#include <string.h>
#include <oci.h>

// Define the maximum number of users to insert
#define MAX_USERS 20

// Define the username and user_id arrays
char username[MAX_USERS][20];
int user_id[MAX_USERS];
int batch_size;

// Define the OCI handles
OCIEnv* envhp;
OCISvcCtx* svchp;
OCIError* errhp;
OCISession* sesshp;
OCIStmt* stmthp;

void bulk_insert_users() {
    // Assign values to host arrays
    strcpy(username[0], "user1");
    user_id[0] = 1001;
    strcpy(username[1], "user2");
    user_id[1] = 1002;
    batch_size = 2;

    // Initialize the OCI environment
    OCIEnvCreate(&envhp, OCI_DEFAULT, NULL, NULL, NULL, NULL, 0, NULL);

    // Initialize the OCI service context
    OCIHandleAlloc(envhp, (dvoid**)&svchp, OCI_HTYPE_SVCCTX, 0, NULL);
    OCIHandleAlloc(envhp, (dvoid**)&errhp, OCI_HTYPE_ERROR, 0, NULL);

    // Set the OCI server handle
    OCIAttrSet(svchp, OCI_HTYPE_SVCCTX, (dvoid*)errhp, 0, OCI_ATTR_SERVER, errhp);

    // Connect to the database
    OCILogon(envhp, errhp, &svchp, (OraText*)username[0], strlen(username[0]), (OraText*)"password", strlen("password"), (OraText*)"localhost/orcl", strlen("localhost/orcl"));

    // Prepare the insert statement
    OCIHandleAlloc(envhp, (dvoid**)&stmthp, OCI_HTYPE_STMT, 0, NULL);
    OCIStmtPrepare(stmthp, errhp, (OraText*)"INSERT INTO users (username, user_id) VALUES (:username, :user_id)", strlen("INSERT INTO users (username, user_id) VALUES (:username, :user_id)"), OCI_NTV_SYNTAX, OCI_DEFAULT);

    // Bind the username and user_id variables
    OCIBind* bindhp;
    OCIHandleAlloc(envhp, (dvoid**)&bindhp, OCI_HTYPE_BIND, 0, NULL);
    OCIBindByName(stmthp, &bindhp, errhp, (OraText*)":username", strlen(":username"), (dvoid*)username[0], strlen(username[0]) + 1, SQLT_STR, NULL, NULL, NULL, 0, NULL, OCI_DEFAULT);
    OCIBindByName(stmthp, &bindhp, errhp, (OraText*)":user_id", strlen(":user_id"), (dvoid*)&user_id[0], sizeof(int), SQLT_INT, NULL, NULL, NULL, 0, NULL, OCI_DEFAULT);

    // Perform the bulk insert
    int i;
    for (i = 0; i < batch_size; i++) {
        OCIBindByName(stmthp, &bindhp, errhp, (OraText*)":username", strlen(":username"), (dvoid*)username[i], strlen(username[i]) + 1, SQLT_STR, NULL, NULL, NULL, 0, NULL, OCI_DEFAULT);
        OCIBindByName(stmthp, &bindhp, errhp, (OraText*)":user_id", strlen(":user_id"), (dvoid*)&user_id[i], sizeof(int), SQLT_INT, NULL, NULL, NULL, 0, NULL, OCI_DEFAULT);
        OCIStmtExecute(svchp, stmthp, errhp, 1, 0, NULL, NULL, OCI_DEFAULT);
    }

    // Commit the transaction
    OCITransCommit(svchp, errhp, OCI_DEFAULT);

    // Release the OCI resources
    OCIHandleFree(stmthp, OCI_HTYPE_STMT);
    OCIHandleFree(svchp, OCI_HTYPE_SVCCTX);
    OCIHandleFree(errhp, OCI_HTYPE_ERROR);
    OCIHandleFree(envhp, OCI_HTYPE_ENV);

    printf("Bulk insert successful\n");
}

int main() {
    bulk_insert_users();
    return 0;
}