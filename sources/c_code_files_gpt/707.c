#include <stdio.h>
#include <sql.h>
#include <sqlext.h>

int main() {
    SQLHENV henv;
    SQLHDBC hdbc;
    SQLHSTMT hstmt;
    SQLRETURN ret;

    // Allocate environment handle
    ret = SQLAllocHandle(SQL_HANDLE_ENV, SQL_NULL_HANDLE, &henv);
    if (ret != SQL_SUCCESS) {
        fprintf(stderr, "SQLAllocHandle failed\n");
        return 1;
    }

    // Set ODBC version
    ret = SQLSetEnvAttr(henv, SQL_ATTR_ODBC_VERSION, (void*)SQL_OV_ODBC3, 0);
    if (ret != SQL_SUCCESS) {
        fprintf(stderr, "SQLSetEnvAttr failed\n");
        SQLFreeHandle(SQL_HANDLE_ENV, henv);
        return 1;
    }

    // Allocate connection handle
    ret = SQLAllocHandle(SQL_HANDLE_DBC, henv, &hdbc);
    if (ret != SQL_SUCCESS) {
        fprintf(stderr, "SQLAllocHandle failed\n");
        SQLFreeHandle(SQL_HANDLE_ENV, henv);
        return 1;
    }

    // Connect to database
    ret = SQLConnect(hdbc, (SQLCHAR*)"your_database", SQL_NTS, (SQLCHAR*)"your_username", SQL_NTS, (SQLCHAR*)"your_password", SQL_NTS);
    if (ret != SQL_SUCCESS) {
        fprintf(stderr, "SQLConnect failed\n");
        SQLFreeHandle(SQL_HANDLE_DBC, hdbc);
        SQLFreeHandle(SQL_HANDLE_ENV, henv);
        return 1;
    }

    // Allocate statement handle
    ret = SQLAllocHandle(SQL_HANDLE_STMT, hdbc, &hstmt);
    if (ret != SQL_SUCCESS) {
        fprintf(stderr, "SQLAllocHandle failed\n");
        SQLDisconnect(hdbc);
        SQLFreeHandle(SQL_HANDLE_DBC, hdbc);
        SQLFreeHandle(SQL_HANDLE_ENV, henv);
        return 1;
    }

    // Prepare SQL statement
    ret = SQLPrepare(hstmt, (SQLCHAR*)"SELECT (CASE profile WHEN ? THEN 1 ELSE 2 END) AS profile_order FROM engine_properties;", SQL_NTS);
    if (ret != SQL_SUCCESS) {
        fprintf(stderr, "SQLPrepare failed\n");
        SQLFreeHandle(SQL_HANDLE_STMT, hstmt);
        SQLDisconnect(hdbc);
        SQLFreeHandle(SQL_HANDLE_DBC, hdbc);
        SQLFreeHandle(SQL_HANDLE_ENV, henv);
        return 1;
    }

    // Bind parameter
    ret = SQLBindParameter(hstmt, 1, SQL_PARAM_INPUT, SQL_C_WCHAR, SQL_WVARCHAR, 32, 0, (SQLPOINTER)"_default", 18, NULL);
    if (ret != SQL_SUCCESS) {
        fprintf(stderr, "SQLBindParameter failed\n");
        SQLFreeHandle(SQL_HANDLE_STMT, hstmt);
        SQLDisconnect(hdbc);
        SQLFreeHandle(SQL_HANDLE_DBC, hdbc);
        SQLFreeHandle(SQL_HANDLE_ENV, henv);
        return 1;
    }

    // Execute SQL statement
    ret = SQLExecute(hstmt);
    if (ret != SQL_SUCCESS) {
        fprintf(stderr, "SQLExecute failed\n");
        SQLFreeHandle(SQL_HANDLE_STMT, hstmt);
        SQLDisconnect(hdbc);
        SQLFreeHandle(SQL_HANDLE_DBC, hdbc);
        SQLFreeHandle(SQL_HANDLE_ENV, henv);
        return 1;
    }

    // Fetch and print results
    while (SQLFetch(hstmt) == SQL_SUCCESS) {
        SQLCHAR profile_order[32];
        SQLGetData(hstmt, 1, SQL_C_WCHAR, profile_order, 32, NULL);
        printf("%s\n", profile_order);
    }

    // Clean up
    SQLFreeHandle(SQL_HANDLE_STMT, hstmt);
    SQLDisconnect(hdbc);
    SQLFreeHandle(SQL_HANDLE_DBC, hdbc);
    SQLFreeHandle(SQL_HANDLE_ENV, henv);

    return 0;
}