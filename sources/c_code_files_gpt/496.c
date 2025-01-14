#include <sqlite3.h>
#include <stdio.h>

int main() {
    sqlite3 *db;
    sqlite3_enable_shared_cache(0); // Ensure this is called before opening the database

    int rc = sqlite3_open("my_database.db", &db);
    if(rc) {
        fprintf(stderr, "Can't open database: %s\n", sqlite3_errmsg(db));
        return rc;
    }

    // Set pragmas to optimize performance
    sqlite3_exec(db, "PRAGMA synchronous = OFF;", 0, 0, 0);
    sqlite3_exec(db, "PRAGMA journal_mode = MEMORY;", 0, 0, 0);

    // Execute your queries
    const char *sql = "SELECT * FROM my_table;";
    sqlite3_stmt *stmt;
    rc = sqlite3_prepare_v2(db, sql, -1, &stmt, 0);
    if(rc != SQLITE_OK) {
        fprintf(stderr, "Failed to prepare statement: %s\n", sqlite3_errmsg(db));
        sqlite3_close(db);
        return rc;
    }

    while((rc = sqlite3_step(stmt)) == SQLITE_ROW) {
        // Process each row
    }

    sqlite3_finalize(stmt);
    sqlite3_close(db);
    return 0;
}