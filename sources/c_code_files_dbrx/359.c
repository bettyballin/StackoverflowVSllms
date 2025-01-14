#include <stdio.h>
#include <sql.h>
#include <sqlext.h>

int main() {
    SQLHSTMT hstmtOut; // declare a statement handle
    SQLINTEGER outputParam; // declare an integer to hold the output value
    SQLRETURN retCode; // declare a variable to hold the return code

    // Assume that hstmtOut has been allocated and set up elsewhere
    // Bind the parameter to retrieve the output value.
    retCode = SQLBindParameter(hstmtOut, 2, SQL_PARAM_OUTPUT, SQL_C_SLONG,
                               NULL, sizeof(outputParam), 0, &outputParam, 0, NULL);
    
    if (retCode != SQL_SUCCESS) {
        printf("Error binding parameter: %d\n", retCode);
    } else {
        printf("Parameter bound successfully\n");
    }

    return 0;
}