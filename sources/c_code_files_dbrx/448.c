#include <stdio.h>
#include <sqlite3.h>
#include <string.h>

void max_min(sqlite3 *db) {
    // callback*********
    int i, ncols;
    sqlite3_stmt *stmt;
    char *sql;
    const char *tail;
    int rc;
    // ******************

    // min/max variables
    int min;
    int max;

    // we want only the min and max value of this table
    sql = "SELECT MIN(Start), MAX(End) FROM GMTI";

    rc = sqlite3_prepare(db, sql, strlen(sql), &stmt, &tail);
    if (rc != SQLITE_OK) {
        fprintf(stderr, "SQL error: %s\n", sqlite3_errmsg(db));
    }

    ncols = sqlite3_column_count(stmt);
    printf("Number of columns: %d\n", ncols);

    while ((rc = sqlite3_step(stmt)) == SQLITE_ROW) {
        min = sqlite3_column_int(stmt, 0);
        max = sqlite3_column_int(stmt, 1);
        printf("MIN(Start): %d, MAX(End): %d\n", min, max);
    }

    if (rc != SQLITE_DONE) {
        fprintf(stderr, "Execution failed: %s\n", sqlite3_errmsg(db));
    } else {
        printf("Query executed successfully.\n");
    }

    rc = sqlite3_finalize(stmt); // finalize the statement
}

int main() {
    sqlite3 *db;
    char *err_msg = NULL;
    int rc = sqlite3_open("your_database.db", &db);
    if (rc != SQLITE_OK) {
        fprintf(stderr, "Cannot open database: %s\n", sqlite3_errmsg(db));
        sqlite3_close(db);
        return 1;
    }

    max_min(db);

    sqlite3_close(db);
    return 0;
}