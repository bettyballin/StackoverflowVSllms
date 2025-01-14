#include <stdio.h>
#include <sql.h>
#include <sqlext.h>

int main() {
    SQLHENV henv;
    SQLHDBC hdbc;
    SQLHSTMT hstmt;
    SQLRETURN ret;
    SQLCHAR dsn[] = "DSN=YourDataSource;UID=your_username;PWD=your_password;";
    SQLCHAR sql[] = "SELECT * FROM EMP";
    SQLCHAR columnData[256];
    SQLLEN columnDataLen;

    // Allocate environment handle
    SQLAllocHandle(SQL_HANDLE_ENV, SQL_NULL_HANDLE, &henv);
    SQLSetEnvAttr(henv, SQL_ATTR_ODBC_VERSION, (void*)SQL_OV_ODBC3, 0);

    // Allocate connection handle
    SQLAllocHandle(SQL_HANDLE_DBC, henv, &hdbc);

    // Connect to the data source
    ret = SQLDriverConnect(hdbc, NULL, dsn, SQL_NTS, NULL, 0, NULL, SQL_DRIVER_COMPLETE);
    if (SQL_SUCCEEDED(ret)) {
        // Allocate statement handle
        SQLAllocHandle(SQL_HANDLE_STMT, hdbc, &hstmt);

        // Execute SQL query
        ret = SQLExecDirect(hstmt, sql, SQL_NTS);
        if (SQL_SUCCEEDED(ret)) {
            // Fetch and display the data
            while (SQLFetch(hstmt) != SQL_NO_DATA) {
                SQLGetData(hstmt, 1, SQL_C_CHAR, columnData, sizeof(columnData), &columnDataLen);
                printf("%s\n", columnData);
            }
        }

        // Free statement handle
        SQLFreeHandle(SQL_HANDLE_STMT, hstmt);
    } else {
        fprintf(stderr, "Failed to connect to the data source.\n");
    }

    // Disconnect and free connection handle
    SQLDisconnect(hdbc);
    SQLFreeHandle(SQL_HANDLE_DBC, hdbc);

    // Free environment handle
    SQLFreeHandle(SQL_HANDLE_ENV, henv);

    return 0;
}