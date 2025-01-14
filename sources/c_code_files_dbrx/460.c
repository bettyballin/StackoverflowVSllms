#include <sqlite3.h>
#include <stdio.h>

int main() {
    sqlite3 *database;
    const char *sql = "INSERT INTO MyTable VALUES(?, ?)";
    if (sqlite3_open("myDatabase.db", &database) == SQLITE_OK) {
        sqlite3_stmt *statement;

        if (sqlite3_prepare_v2(database, sql, -1, &statement, NULL) == SQLITE_OK) {
            // Bind values to prepared statement here, depending on its type.
            const char* valueA = "Hello";
            sqlite3_bind_text(statement, 1, valueA, -1, SQLITE_TRANSIENT); // Bind `valueA` first ? parameter

            int intValueB = 42;
            sqlite3_bind_int(statement, 2, intValueB);// Bind integer in the second ? of statement.

            if (sqlite3_step(statement) != SQLITE_DONE) {
                // Handle error here by checking `sqlite3_errmsg` function for more details.
                printf("An error occurred while inserting data: %s\n", sqlite3_errmsg(database));
            } else {
                printf("Data inserted successfully!\n");
            }

            sqlite3_finalize(statement);
        }

        sqlite3_close(database);
    }

    return 0;
}