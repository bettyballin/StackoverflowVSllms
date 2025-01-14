#include <stdio.h>
#include <string.h>
#include <oci.h>

int main() {
    /* OCI Handles */
    OCIEnv* envhp;
    OCISvcCtx* svchp;
    OCIError* errhp;
    OCIStmt* stmthp;
    OCISession* authp;

    /* Connect string */
    char username[] = "your_username";
    char password[] = "your_password";
    char dbstring[] = "your_database";

    /* Input SQL statement */
    const char *sql = "SELECT your_integer_column FROM your_table";

    /* Initialize OCI */
    if (OCIEnvCreate((OCIEnv**)&envhp, (ub4)OCI_DEFAULT, (dvoid*)0, (dvoid* (*)(dvoid*, size_t)) 0, (dvoid* (*)(dvoid*, dvoid*, size_t))0, (size_t) 0, (dvoid**) 0))
    {
        printf("Failed to create OCI environment\n");
        return 1;
    }

    /* Initialize Error Handle */
    if (OCIHandleAlloc(envhp, (dvoid**)&errhp, OCI_HTYPE_ERROR, (size_t)0, (dvoid**)0))
    {
        printf("Failed to allocate OCI error handle\n");
        return 1;
    }

    /* Attach to an existing shared server process and initialize service context */
    if (OCIEnvInit((OCIEnv**)&envhp, OCI_DEFAULT, 0, (dvoid**)0))
    {
        printf("Failed to initialize OCI environment\n");
        return 1;
    }

    /* Server Attach */
    if (OCIServerAttach(envhp, errhp, (OCIServer**)&svchp, (sb4)strlen(dbstring), (text*)dbstring))
    {
        printf("Failed to attach to server\n");
        return 1;
    }

    /* Initialize Service Context */
    if (OCIHandleAlloc(envhp, (dvoid**)&svchp, OCI_HTYPE_SVCCTX, (size_t)0, (dvoid**)0))
    {
        printf("Failed to allocate OCI service context handle\n");
        return 1;
    }

    /* Initialize Server Handle */
    if (OCIHandleAlloc(envhp, (dvoid**)&authp, OCI_HTYPE_SESSION, (size_t)0, (dvoid**)0))
    {
        printf("Failed to allocate OCI session handle\n");
        return 1;
    }

    /* Initialize User Session */
    if (OCIAttrSet((dvoid*)authp, (ub4)OCI_HTYPE_SESSION, (dvoid*)username, (ub4)strlen(username), OCI_ATTR_USERNAME, errhp))
    {
        printf("Failed to set username\n");
        return 1;
    }
    if (OCIAttrSet((dvoid*)authp, (ub4)OCI_HTYPE_SESSION, (dvoid*)password, (ub4)strlen(password), OCI_ATTR_PASSWORD, errhp))
    {
        printf("Failed to set password\n");
        return 1;
    }

    /* Begin a user session */
    if (OCISessionBegin(svchp, errhp, authp, OCI_CRED_RDBMS, OCI_DEFAULT))
    {
        printf("Failed to begin user session\n");
        return 1;
    }

    /* Allocate Statement Handle */
    if (OCIHandleAlloc(envhp, (dvoid**)&stmthp, OCI_HTYPE_STMT, (size_t)0, (dvoid**)0))
    {
        printf("Failed to allocate OCI statement handle\n");
        return 1;
    }

    /* Prepare SQL statement */
    if (OCIStmtPrepare(stmthp, errhp, (const OraText*)sql, (ub4)strlen(sql), OCI_NTV_SYNTAX, OCI_DEFAULT))
    {
        printf("Failed to prepare SQL statement\n");
        return 1;
    }

    /* At this point, you would typically execute the statement with OCIStmtExecute, 
     * then fetch and process the results. However, for brevity, these steps are omitted here. */

    /* Cleanup */
    OCIHandleFree((dvoid*)stmthp, OCI_HTYPE_STMT);
    OCIHandleFree((dvoid*)svchp, OCI_HTYPE_SVCCTX);
    OCIHandleFree((dvoid*)authp, OCI_HTYPE_SESSION);
    OCIHandleFree((dvoid*)errhp, OCI_HTYPE_ERROR);
    OCIServerDetach(svchp, errhp, OCI_DEFAULT);
    OCIHandleFree((dvoid*)envhp, OCI_HTYPE_ENV);

    return 0;
}