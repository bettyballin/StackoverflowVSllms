#include <sqlite3.h>
#include <string.h>
#include <stdio.h>

int main() {
    sqlite3* db;
    int sqliteRet;

    // Open the SQLite database
    sqliteRet = sqlite3_open("example.db", &db);
    if (sqliteRet != SQLITE_OK) {
        printf("Error opening database: %s\n", sqlite3_errmsg(db));
        return 1;
    }

    // Set the encryption key (assuming it's a string)
    const char* keydata = "your_encryption_password";
    sqliteRet = sqlite3_key(db, keydata, strlen(keydata));
    if (sqliteRet != SQLITE_OK) {
        printf("Error setting encryption key: %s\n", sqlite3_errmsg(db));
        sqlite3_close(db);
        return 1;
    }

    // Close the database
    sqlite3_close(db);
    return 0;
}