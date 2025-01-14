#include <sqlite3.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    sqlite3* database;
    sqlite3_stmt* statement;
    int rc;
    int serviceId = 1; // Example service ID
    char* startTimeStr = "2023-01-01 00:00:00"; // Example start time
    char* endTimeStr = "2023-01-01 23:59:59"; // Example end time

    // Open the database
    rc = sqlite3_open("example.db", &database);
    if (rc) {
        fprintf(stderr, "Cannot open database: %s\n", sqlite3_errmsg(database));
        exit(1);
    }

    // Prepare the SQL statement
    const char* sql = "SELECT * FROM example_table WHERE serviceId=? AND startTime=? AND endTime=?";
    rc = sqlite3_prepare_v2(database, sql, -1, &statement, 0);
    if (rc != SQLITE_OK) {
        fprintf(stderr, "SQL error: %s\n", sqlite3_errmsg(database));
        sqlite3_close(database);
        exit(1);
    }

    // Bind data
    sqlite3_bind_int(statement, 1, serviceId);
    sqlite3_bind_text(statement, 2, startTimeStr, -1, SQLITE_STATIC);
    sqlite3_bind_text(statement, 3, endTimeStr, -1, SQLITE_STATIC);

    // Execute the query
    while ((rc = sqlite3_step(statement)) == SQLITE_ROW) {
        printf("%s\n", sqlite3_column_text(statement, 0));
    }

    if (rc != SQLITE_DONE) {
        fprintf(stderr, "SQL error: %s\n", sqlite3_errmsg(database));
    }

    // Clean up
    sqlite3_finalize(statement);
    sqlite3_close(database);

    return 0;
}