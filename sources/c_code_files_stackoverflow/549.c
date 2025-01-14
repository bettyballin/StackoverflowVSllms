#include <sqlite3.h>

int main() {
    sqlite3* db;
    sqlite3_stmt* statement_handle;

    // Open the database
    int rc = sqlite3_open("example.db", &db);
    if (rc) {
        fprintf(stderr, "Cannot open database: %s\n", sqlite3_errmsg(db));
        return 1;
    }

    // Prepare the SQL statement
    rc = sqlite3_prepare_v2(db, "select a,b from Table where c = ?", -1, &statement_handle, NULL);
    if (rc != SQLITE_OK) {
        fprintf(stderr, "SQL error: %s\n", sqlite3_errmsg(db));
        sqlite3_close(db);
        return 1;
    }

    // Clean up
    sqlite3_finalize(statement_handle);
    sqlite3_close(db);
    return 0;
}