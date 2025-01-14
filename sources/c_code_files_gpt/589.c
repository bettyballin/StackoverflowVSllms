#include <stdio.h>
#include <sql.h>
#include <sqlext.h>

int main() {
    SQLHSTMT hStmt;
    SQLRETURN retcode;
    SQLINTEGER retValue;
    SQLLEN indicator;

    // Assume hStmt is already allocated and connected
    // For a complete example, you would need to include the code to allocate and connect hStmt
    // using functions like SQLAllocHandle, SQLSetEnvAttr, SQLConnect, etc.

    // Execute the stored procedure
    retcode = SQLExecDirect(hStmt, (SQLCHAR*)"EXEC YourStoredProcedure", SQL_NTS);

    if (retcode == SQL_SUCCESS || retcode == SQL_SUCCESS_WITH_INFO) {
        // Fetch the result set
        retcode = SQLFetch(hStmt);
        if (retcode == SQL_SUCCESS || retcode == SQL_SUCCESS_WITH_INFO) {
            // Retrieve the value of the result set
            retcode = SQLGetData(hStmt, 1, SQL_C_SLONG, &retValue, 0, &indicator);
            if (retcode == SQL_SUCCESS || retcode == SQL_SUCCESS_WITH_INFO) {
                printf("Retrieved value: %d\n", retValue);
                // Use retValue which now contains the value 0
            }
        }
    }

    // Cleanup
    SQLFreeStmt(hStmt, SQL_CLOSE);

    return 0;
}