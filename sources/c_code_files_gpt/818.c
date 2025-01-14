#include <sqlite3.h>

int main() {
    sqlite3_stmt *sql_stmt;
    int service_id;
    struct {
        char *start;
        char *end;
    } ts;
    int rc;

    // Initialize the SQLite database connection and prepare the SQL statement
    // ... (omitted for brevity)

    rc = sqlite3_bind_int(sql_stmt, 1, service_id);
    rc = sqlite3_bind_text(sql_stmt, 2, ts.start, -1, SQLITE_TRANSIENT);
    rc = sqlite3_bind_text(sql_stmt, 3, ts.end, -1, SQLITE_TRANSIENT);
    rc = sqlite3_bind_text(sql_stmt, 4, ts.start, -1, SQLITE_TRANSIENT);
    rc = sqlite3_bind_text(sql_stmt, 5, ts.end, -1, SQLITE_TRANSIENT);
    rc = sqlite3_bind_text(sql_stmt, 6, ts.start, -1, SQLITE_TRANSIENT);
    rc = sqlite3_bind_text(sql_stmt, 7, ts.end, -1, SQLITE_TRANSIENT);

    // Finalize the SQL statement and close the SQLite database connection
    // ... (omitted for brevity)

    return 0;
}