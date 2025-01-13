#include <windows.h>\n#include <sqlext.h>\n#include <iostream>\n\nvoid GetRowColCount(SQLHSTMT hstmt, SQLINTEGER &rowCount, SQLSMALLINT &colCount) {\n    // Get the number of columns\n    SQLNumResultCols(hstmt, &colCount);\n\n    // Initialize the row count\n    rowCount = 0;\n\n    // Fetch each row and count\n    while (SQLFetch(hstmt) != SQL_NO_DATA) {\n        rowCount++;\n    }\n\n    // Reset the cursor to the beginning if needed for further processing\n    SQLCloseCursor(hstmt);\n    SQLExecute(hstmt); // Re-execute the statement to reset the cursor\n}\n\nint main() {\n    SQLHENV henv;\n    SQLHDBC hdbc;\n    SQLHSTMT hstmt;\n    SQLRETURN ret;\n    SQLINTEGER rowCount;\n    SQLSMALLINT colCount;\n\n    // Allocate environment handle\n    SQLAllocHandle(SQL_HANDLE_ENV, SQL_NULL_HANDLE, &henv);\n    SQLSetEnvAttr(henv, SQL_ATTR_ODBC_VERSION, (void *) SQL_OV_ODBC3, 0);\n\n    // Allocate connection handle\n    SQLAllocHandle(SQL_HANDLE_DBC, henv, &hdbc);\n\n    // Connect to the data source\n    SQLConnect(hdbc, (SQLCHAR *)"DSN=your_dsn;", SQL_NTS, (SQLCHAR *)NULL, 0, NULL, 0);\n\n    // Allocate statement handle\n    SQLAllocHandle(SQL_HANDLE_STMT, hdbc, &hstmt);\n\n    // Execute your query\n    SQLExecDirect(hstmt, (SQLCHAR *)"SELECT * FROM your_table;", SQL_NTS);\n\n    // Get row and column count\n    GetRowColCount(hstmt, rowCount, colCount);\n\n    // Print the result\n    std::cout << "Number of rows: " << rowCount << "\n";\n    std::cout << "Number of columns: " << colCount << "\n";\n    std::cout << "Total elements: " << rowCount * colCount << "\n";\n\n    // Clean up\n    SQLFreeHandle(SQL_HANDLE_STMT, hstmt);\n    SQLDisconnect(hdbc);\n    SQLFreeHandle(SQL_HANDLE_DBC, hdbc);\n    SQLFreeHandle(SQL_HANDLE_ENV, henv);\n\n    return 0;\n}