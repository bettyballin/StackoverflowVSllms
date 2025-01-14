#include <stdio.h>
#include <string.h>
#include <sqlite3.h>

void max_min(sqlite3 *db) {
    sqlite3_stmt *stmt;
    const char *sql = "SELECT MIN(Start), MAX(End) FROM GMTI;";
    int rc;
    char min[20] = {0};
    char max[20] = {0};

    rc = sqlite3_prepare_v2(db, sql, -1, &stmt, NULL);
    if (rc != SQLITE_OK) {
        fprintf(stderr, "SQL error: %s\n", sqlite3_errmsg(db));
        return;
    }

    rc = sqlite3_step(stmt);
    if (rc == SQLITE_ROW) {
        const unsigned char *min_value = sqlite3_column_text(stmt, 0);
        const unsigned char *max_value = sqlite3_column_text(stmt, 1);

        if (min_value) {
            strncpy(min, (const char*)min_value, sizeof(min) - 1);
        }
        if (max_value) {
            strncpy(max, (const char*)max_value, sizeof(max) - 1);
        }

        printf("min is: %s\n", min);
        printf("max is: %s\n", max);
    } else {
        fprintf(stderr, "Failed to retrieve min and max values\n");
    }

    sqlite3_finalize(stmt);
}

int main() {
    sqlite3 *db;
    char *errMsg = NULL;
    int rc = sqlite3_open("your_database.db", &db);
    
    if (rc) {
        fprintf(stderr, "Can't open database: %s\n", sqlite3_errmsg(db));
        return 1;
    } else {
        printf("Opened database successfully\n");
    }
    
    max_min(db);
    
    sqlite3_close(db);
    return 0;
}