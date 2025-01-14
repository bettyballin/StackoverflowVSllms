#include <mysql/mysql.h>
#include <stdio.h>
#include <stdlib.h>

void get_foreign_keys(MYSQL *conn, const char *db_name, const char *table_name) {
    char query[1024];
    // Using snprintf to avoid buffer overflow, ensuring null-termination
    if (snprintf(query, sizeof(query),
                 "SELECT TABLE_NAME, COLUMN_NAME, CONSTRAINT_NAME, REFERENCED_TABLE_NAME, REFERENCED_COLUMN_NAME "
                 "FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE "
                 "WHERE TABLE_SCHEMA = '%s' AND TABLE_NAME = '%s' AND REFERENCED_TABLE_NAME IS NOT NULL",
                 db_name, table_name) >= sizeof(query)) {
        fprintf(stderr, "Query string too long.\n");
        return;
    }

    if (mysql_query(conn, query)) {
        fprintf(stderr, "Query failed: %s\n", mysql_error(conn));
        return;
    }

    MYSQL_RES *result = mysql_store_result(conn);
    if (result == NULL) {
        fprintf(stderr, "Result storing failed: %s\n", mysql_error(conn));
        return;
    }

    MYSQL_ROW row;
    while ((row = mysql_fetch_row(result))) {
        printf("Table: %s, Column: %s, Constraint: %s, Referenced Table: %s, Referenced Column: %s\n",
               row[0], row[1], row[2], row[3], row[4]);
    }

    mysql_free_result(result);
}

int main() {
    MYSQL *conn = mysql_init(NULL);
    if (conn == NULL) {
        fprintf(stderr, "mysql_init() failed\n");
        return 1;
    }

    // Change "host", "user", "password", "database" to your actual MySQL database credentials and database name
    if (mysql_real_connect(conn, "host", "user", "password", "database", 0, NULL, 0) == NULL) {
        fprintf(stderr, "mysql_real_connect() failed\n");
        mysql_close(conn);
        return 1;
    }

    // Change "your_database_name" and "MyTableName" to the database and table you want to query
    get_foreign_keys(conn, "your_database_name", "MyTableName");

    mysql_close(conn);
    return 0;
}