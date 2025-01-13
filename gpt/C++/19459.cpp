#include <iostream>\n#include <sql.h>\n#include <sqlext.h>\n\nvoid executeQuery() {\n    SQLHANDLE hEnv = SQL_NULL_HENV;\n    SQLHANDLE hDbc = SQL_NULL_HDBC;\n    SQLHANDLE hStmt = SQL_NULL_HSTMT;\n    SQLRETURN ret;\n\n    // Allocate environment handle\n    ret = SQLAllocHandle(SQL_HANDLE_ENV, SQL_NULL_HANDLE, &hEnv);\n    \n    // Set the ODBC version environment attribute\n    if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO) {\n        ret = SQLSetEnvAttr(hEnv, SQL_ATTR_ODBC_VERSION, (void*)SQL_OV_ODBC3, 0);\n    }\n\n    // Allocate connection handle\n    if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO) {\n        ret = SQLAllocHandle(SQL_HANDLE_DBC, hEnv, &hDbc);\n    }\n\n    // Connect to the database\n    if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO) {\n        ret = SQLConnect(hDbc, (SQLCHAR*)"DATABASE_NAME", SQL_NTS, \n                         (SQLCHAR*)"USER", SQL_NTS, \n                         (SQLCHAR*)"PASSWORD", SQL_NTS);\n    }\n\n    // Allocate statement handle\n    if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO) {\n        ret = SQLAllocHandle(SQL_HANDLE_STMT, hDbc, &hStmt);\n    }\n\n    // Prepare the SQL query with placeholders\n    if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO) {\n        SQLCHAR* sqlQuery = (SQLCHAR*)"SELECT * FROM Employees WHERE EmployeeID = ?";\n        ret = SQLPrepare(hStmt, sqlQuery, SQL_NTS);\n    }\n\n    // Bind the parameter value\n    if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO) {\n        SQLINTEGER employeeID = 12345;\n        ret = SQLBindParameter(hStmt, 1, SQL_PARAM_INPUT, SQL_C_LONG, SQL_INTEGER, 0, 0, &employeeID, 0, NULL);\n    }\n\n    // Execute the query\n    if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO) {\n        ret = SQLExecute(hStmt);\n    }\n\n    // Fetch and display the results\n    if (ret == SQL_SUCCESS || ret == SQL_SUCCESS_WITH_INFO) {\n        SQLCHAR name[64];\n        SQLINTEGER id;\n\n        while (SQLFetch(hStmt) == SQL_SUCCESS) {\n            SQLGetData(hStmt, 1, SQL_C_LONG, &id, 0, NULL);\n            SQLGetData(hStmt, 2, SQL_C_CHAR, name, sizeof(name), NULL);\n            std::cout << "Employee ID: " << id << ", Name: " << name << std::endl;\n        }\n    }\n\n    // Clean up\n    if (hStmt != SQL_NULL_HSTMT) SQLFreeHandle(SQL_HANDLE_STMT, hStmt);\n    if (hDbc != SQL_NULL_HDBC) {\n        SQLDisconnect(hDbc);\n        SQLFreeHandle(SQL_HANDLE_DBC, hDbc);\n    }\n    if (hEnv != SQL_NULL_HENV) SQLFreeHandle(SQL_HANDLE_ENV, hEnv);\n}\n\nint main() {\n    executeQuery();\n    return 0;\n}