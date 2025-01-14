#include <sqlite3.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    sqlite3* dbHandle;
    sqlite3_stmt* stmt;
    const char * query = "SELECT name, email FROM users WHERE id=? AND age>=?";
    int rc;

    // Open the database
    rc = sqlite3_open("example.db", &dbHandle);
    if (rc) {
        fprintf(stderr, "Cannot open database: %s\n", sqlite3_errmsg(dbHandle));
        return 1;
    }

    // Prepare a statement with two placeholders '?'
    rc = sqlite3_prepare_v2(dbHandle, query, -1, &stmt, 0);
    if (rc != SQLITE_OK) {
        fprintf(stderr, "SQL error: %s\n", sqlite3_errmsg(dbHandle));
        sqlite3_close(dbHandle);
        return 1;
    }

    // Example values for userId and age
    int64_t userId = 1;
    int64_t age = 18;

    // Bind the parameters to the placeholders
    sqlite3_bind_int64(stmt, 1, userId);
    sqlite3_bind_int64(stmt, 2, age);

    // Execute statement
    while ((rc = sqlite3_step(stmt)) == SQLITE_ROW) {
        const unsigned char *name = sqlite3_column_text(stmt, 0);
        const unsigned char *email = sqlite3_column_text(stmt, 1);
        printf("Name: %s, Email: %s\n", name, email);
    }

    if (rc != SQLITE_DONE) {
        fprintf(stderr, "SQL error: %s\n", sqlite3_errmsg(dbHandle));
    }

    // Clean up
    sqlite3_finalize(stmt);
    sqlite3_close(dbHandle);

    return 0;
}