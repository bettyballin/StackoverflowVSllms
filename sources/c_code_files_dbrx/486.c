#include <sql.h>
#include <sqlext.h>

int main() {
    SQLHDBC hdbc; // Assuming hdbc is a valid connection handle
    SQLRETURN retcode;

    retcode = SQLSetConnectAttr(hdbc, SQL_ATTR_ASYNC_ENABLE, (void *)SQL_ASYNC_ENABLE_ON, 0);
    if (!SQL_SUCCEEDED(retcode)) {
        // Error handling here...
    }

    return 0;
}