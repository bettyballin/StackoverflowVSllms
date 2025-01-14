#include <stdio.h>
#include <sqlite3.h>

int main() {
    sqlite3 *db;
    char* filename = "/path/to/my.db";
    int error_code = sqlite3_open(filename, &db);
    if (error_code) {
        fprintf(stderr, "%s\n", sqlite3_errmsg(db));
        return -1;
    }

    sqlite3_stmt *prep;
    char command[] = "CREATE TABLE test (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT);";
    error_code = sqlite3_prepare_v2(db, command, sizeof(command), &prep, 0);
    if (error_code) {
        fprintf(stderr, "SQL ERROR %s\n", sqlite3_errmsg(db));
        sqlite3_close(db); // Close the database connection on error
        return -1;
    }

    // After preparing the statement, you typically execute it and then finalize it.
    // These steps are omitted here as the focus is on making the provided code executable.
    // In a real scenario, you would call sqlite3_step() and sqlite3_finalize().

    sqlite3_close(db); // Close the database connection
    return 0;
}