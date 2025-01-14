#include <stdio.h>
#include <sqlite3.h>

int main() {
    const char *sql = 
        "SELECT *, rowid "
        "FROM tblEvent_basic "
        "WHERE service_id = ? AND ("
        "    (start_time >= ? AND start_time <= ?) OR "
        "    (end_time > ? AND end_time < ?) OR "
        "    (start_time < ? AND end_time > ?) "
        ") "
        "ORDER BY start_time ASC";

    // You may want to use the sql string in a SQLite query here
    // For example:
    sqlite3 *db;
    sqlite3_stmt *stmt;
    sqlite3_open("example.db", &db);
    sqlite3_prepare_v2(db, sql, -1, &stmt, 0);
    // ... bind parameters and execute the query ...

    return 0;
}