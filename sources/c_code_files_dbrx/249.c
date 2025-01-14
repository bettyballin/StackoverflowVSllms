#include <stdio.h>
#include <sql.h>
#include <sqlext.h>

int main() {
    RETCODE retcode;
    SQLINTEGER length;
    SQLHSTMT StatementHandle; // Assuming this is defined and initialized elsewhere
    int col_num = 1; // Example column number, adjust as necessary
    // Assuming very_long_string is a std::string, which is not standard C. For C, we'll use a char array.
    char very_long_string[] = "Your very long string here";
    length = sizeof(very_long_string) - 1; // -1 to exclude the null terminator

    // Assuming StatementHandle is already set up and valid
    retcode = SQLBindParameter(StatementHandle,                // Statement Handle
                               col_num,                        // input-output param number
                               SQL_PARAM_INPUT,        	      // the type of operation for this parameter (input)
                               SQL_C_BINARY,            	      // DataType is binary to hold the long data.
                               SQL_VARCHAR|SQL_LONGVARCHAR,     // C-data type: Varchar with no limits length.
                               0,                                // Parameter size of column in bytes or characters.
                               0,	   	                          // Decimal digits for output parameters and indicators otherwise ignored.
                               (SQLPOINTER)very_long_string,     // Data pointer to the parameter value.
                               length,                     	  // Buffer size is in bytes or characters.
                               &length);             	        // Length of string data passed back from driver.

    if (retcode == SQL_SUCCESS || retcode == SQL_SUCCESS_WITH_INFO) {
        printf("SQLBindParameter was successful.\n");
    } else {
        printf("SQLBindParameter failed.\n");
    }

    return 0;
}