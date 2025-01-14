#include <mysql/mysql.h>
#include <stdio.h>

int main() {
    MYSQL *conn;
    MYSQL_STMT *stmt;
    MYSQL_BIND bind[1];
    int id;
    my_bool is_null;

    // Initialize MySQL connection
    conn = mysql_init(NULL);
    if (conn == NULL) {
        fprintf(stderr, "mysql_init() failed\n");
        return 1;
    }

    // Connect to the database
    if (mysql_real_connect(conn, "host", "user", "password", "database", 0, NULL, 0) == NULL) {
        fprintf(stderr, "mysql_real_connect() failed\n");
        mysql_close(conn);
        return 1;
    }

    // Prepare the SQL statement
    stmt = mysql_stmt_init(conn);
    if (stmt == NULL) {
        fprintf(stderr, "mysql_stmt_init() failed\n");
        mysql_close(conn);
        return 1;
    }

    const char *query = "SELECT id FROM your_table WHERE some_condition";
    if (mysql_stmt_prepare(stmt, query, strlen(query)) != 0) {
        fprintf(stderr, "mysql_stmt_prepare() failed\n");
        mysql_stmt_close(stmt);
        mysql_close(conn);
        return 1;
    }

    // Bind the result buffer
    memset(bind, 0, sizeof(bind));
    bind[0].buffer_type = MYSQL_TYPE_LONG;
    bind[0].buffer = (char *)&id;
    bind[0].is_null = &is_null;

    if (mysql_stmt_bind_result(stmt, bind) != 0) {
        fprintf(stderr, "mysql_stmt_bind_result() failed\n");
        mysql_stmt_close(stmt);
        mysql_close(conn);
        return 1;
    }

    // Execute the statement
    if (mysql_stmt_execute(stmt) != 0) {
        fprintf(stderr, "mysql_stmt_execute() failed\n");
        mysql_stmt_close(stmt);
        mysql_close(conn);
        return 1;
    }

    // Fetch the result
    while (mysql_stmt_fetch(stmt) == 0) {
        if (!is_null) {
            printf("ID: %d\n", id);
        } else {
            printf("ID is NULL\n");
        }
    }

    // Clean up
    mysql_stmt_close(stmt);
    mysql_close(conn);

    return 0;
}