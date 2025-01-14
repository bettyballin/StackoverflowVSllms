#include <stdio.h>
#include <stdlib.h>
#include <sql.h>
#include <sqlext.h>

int main() {
    SQLHDBC hDbc;
    SQLHSTMT hStatement;
    SQLINTEGER nInt64 = 1234567890; // Replace with your desired value

    // Assume a connection has been established and hDbc is a valid connection handle
    SQLAllocHandle(SQL_HANDLE_STMT, hDbc, &hStatement);
    SQLPrepare(hStatement, (SQLCHAR*)"INSERT INTO test (testcol) VALUES (?);", SQL_NTS);

    SQLCHAR strInt64[21]; // Buffer to hold the string representation of int64
    snprintf((char*)strInt64, sizeof(strInt64), "%lld", nInt64);

    SQLINTEGER nStrLen = SQL_NTS;
    SQLBindParameter(hStatement, 1, SQL_PARAM_INPUT, SQL_C_CHAR, SQL_CHAR, 20, 0, strInt64, 0, &nStrLen);

    SQLRETURN ret = SQLExecute(hStatement);
    if (ret == SQL_ERROR) {
        SQLCHAR sqlState[6];
        SQLINTEGER nativeError;
        SQLCHAR messageText[256];
        SQLSMALLINT textLength;
        SQLGetDiagRec(SQL_HANDLE_STMT, hStatement, 1, sqlState, &nativeError, messageText, sizeof(messageText), &textLength);
        printf("Error: %s\n", messageText);
    }

    // Clean up
    SQLFreeHandle(SQL_HANDLE_STMT, hStatement);
    return 0;
}