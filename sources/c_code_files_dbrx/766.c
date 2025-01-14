#include <stdio.h>
#include <string.h>
#include <oci.h>

int main() {
    OCIStmt *p_sql;
    OCIError *p_err;
    OCIBind *p1bindhp, *p2bindhp, *xbindhp;
    char sql_stmt[256];
    int rc;
    ub4 plenind;
    int ret;

    /* build sql statement calling function */
    strcpy(sql_stmt, "begin :x := get_seq_number(:p1, :p2); end;");
    rc = OCIStmtPrepare(p_sql, p_err, sql_stmt, (ub4)strlen(sql_stmt), (ub4)OCI_NTV_SYNTAX, (ub4)OCI_DEFAULT);

    /* bind the input parameters */
    OCIBindByPos(p_sql, &p1bindhp, p_err, 2, (dvoid *)0, (sb4*)&plenind, (text*)":p1", (sb4)strlen((char *)":p1"), OCI_DEFAULT);
    OCIBindByPos(p_sql, &p2bindhp, p_err, 3, (dvoid *)0, (sb4*)&plenind, (text*)":p2", (sb4)strlen((char *)":p2"), OCI_DEFAULT);

    /* bind the output parameter */
    OCIBindByPos(p_sql, &xbindhp, p_err, 1, (dvoid *)&ret, (sb4*)&plenind, (text*)":x", (sb4)strlen((char *)":x"), OCI_DEFAULT);

    return 0;
}