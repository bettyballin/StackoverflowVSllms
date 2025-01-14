#include <sql.h>
#include <sqlext.h>

int main() {
    __int64 nInt64 = 99;
    SQLLEN cbNumPrecision = 0; // set the desired precision, e.g., 38
    SQLLEN cbNumScale = 0;     // set the desired scale, e.g., 0 for whole numbers
    SQLHSTMT hStatement;

    // Assume you have already allocated the statement handle
    // If not, you need to allocate it using SQLAllocHandle

    SQLBindParameter(hStatement, 1, SQL_PARAM_INPUT,
       SQL_C_SBIGINT, SQL_NUMERIC, cbNumPrecision, cbNumScale, &nInt64, sizeof(__int64), NULL);

    return 0;
}