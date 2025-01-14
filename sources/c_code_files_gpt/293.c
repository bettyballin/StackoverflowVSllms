#include <stdio.h>
#include <sqlite3.h>

// Example user-defined function to concatenate two strings
void concatFunc(sqlite3_context *context, int argc, sqlite3_value **argv) {
    if (argc == 2) {
        const unsigned char *str1 = sqlite3_value_text(argv[0]);
        const unsigned char *str2 = sqlite3_value_text(argv[1]);

        if (str1 && str2) {
            char *result = sqlite3_mprintf("%s%s", str1, str2);
            sqlite3_result_text(context, result, -1, sqlite3_free);
        } else {
            sqlite3_result_null(context);
        }
    } else {
        sqlite3_result_null(context);
    }
}

int main() {
    sqlite3 *db;
    char *errMsg = 0;
    int rc;

    // Open the database
    rc = sqlite3_open("example.db", &db);
    if (rc) {
        fprintf(stderr, "Can't open database: %s\n", sqlite3_errmsg(db));
        return 1;
    }

    // Register the user-defined function
    rc = sqlite3_create_function(db, "concat", 2, SQLITE_UTF8, NULL, concatFunc, NULL, NULL);
    if (rc) {
        fprintf(stderr, "Can't create function: %s\n", sqlite3_errmsg(db));
        sqlite3_close(db);
        return 1;
    }

    // Execute a query using the user-defined function
    const char *sql = "SELECT concat('Hello, ', 'world!');";
    rc = sqlite3_exec(db, sql, NULL, NULL, &errMsg);
    if (rc != SQLITE_OK) {
        fprintf(stderr, "SQL error: %s\n", errMsg);
        sqlite3_free(errMsg);
    } else {
        printf("Query executed successfully\n");
    }

    // Close the database
    sqlite3_close(db);
    return 0;
}