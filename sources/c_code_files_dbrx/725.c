#include <stdio.h>
#include <sqlite3.h>

void my_func(sqlite3 *db){
    // Use 'db' for your operations here...
}

int main() {
    sqlite3* db;
    if (sqlite3_open("mydatabase.sql", &db) == SQLITE_OK) {
        printf("Connected to database.\n");
        my_func(db);  // Calling your function with the open 'db' handle.
        sqlite3_close(db);
    } else {
        fprintf(stderr, "Error: Can't open database: %s\n", sqlite3_errmsg(db));
        return -1;
    }
    return 0;
}