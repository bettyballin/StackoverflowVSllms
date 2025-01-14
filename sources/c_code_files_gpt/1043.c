#include <stdio.h>
#include <stdlib.h>

int main() {
    // Set the Oracle environment variables
    putenv("ORACLE_HOME=C:\\oraclexe\\app\\oracle\\product\\10.2.0\\server");
    putenv("TNS_ADMIN=C:\\oraclexe\\app\\oracle\\product\\10.2.0\\server\
etwork\\admin");
    putenv("NLS_LANG=AMERICAN_AMERICA.AL32UTF8");

    // Attempt to connect to the Oracle database using ODBC
    // Your ODBC connection code here

    return 0;
}