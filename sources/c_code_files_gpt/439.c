#include <mysql/mysql.h>
#include <stdio.h>

int main() {
    MYSQL *conn;
    conn = mysql_init(NULL);

    if (conn == NULL) {
        printf("Error %u: %s\n", mysql_errno(conn), mysql_error(conn));
        exit(1);
    }

    if (mysql_real_connect(conn, "localhost", "username", "password", "database", 0, NULL, 0) == NULL) {
        printf("Error %u: %s\n", mysql_errno(conn), mysql_error(conn));
        mysql_close(conn);
        exit(1);
    }

    printf("Connected to MySQL database successfully!\n");

    mysql_close(conn);
    return 0;
}