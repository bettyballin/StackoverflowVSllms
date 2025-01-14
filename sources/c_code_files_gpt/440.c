#include <mysql.h>
#include <stdio.h> // Include stdio.h for fprintf

int main() {
    MYSQL *conn;
    conn = mysql_init(NULL);
    if (conn == NULL) {
        fprintf(stderr, "mysql_init() failed\n"); // Added newline character at the end
        return 1;
    }
    // Additional MySQL code here
    mysql_close(conn);
    return 0;
}