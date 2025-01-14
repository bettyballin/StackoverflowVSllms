#include <stdio.h>
#include <mysql/mysql.h>

int main() {
    MYSQL *con; // MySQL connection
    MYSQL_RES* result = NULL; // Result set
    MYSQL_ROW row; // Row in the result set
    unsigned int num_fields;
    int status;

    // Initialize MySQL library
    mysql_library_init(0, NULL, NULL);

    // Establish a connection (example parameters, replace with your actual database credentials and host)
    con = mysql_init(NULL);
    if (!mysql_real_connect(con, "127.0.0.1", "your_username", "your_password", "your_database", 0, NULL, 0)) {
        fprintf(stderr, "%s\n", mysql_error(con));
        mysql_close(con);
        mysql_library_end();
        return 1;
    }

    if (mysql_query(con, "SELECT your_column FROM table_name")) {
        fprintf(stderr, "%s\n", mysql_error(con));
    } else {
        // Change client flags to binary protocol
        unsigned long flags = 0x2 | MYSQL_CLIENT_INTERACTIVE;
        if (mysql_real_query(con, "SET SESSION binlog_format=BINARY", strlen("SET SESSION binlog_format=BINARY")) != 0) {
            fprintf(stderr, "%s\n", mysql_error(con));
        } else {
            result = mysql_store_result(con);
            num_fields = mysql_num_fields(result);
            while ((row = mysql_fetch_row(result))) {
                for(int i = 0; i < num_fields; i++) {
                    printf("Row value: %s\n", row[i]); // You'll get result as binary data without any additional encoding.
                }
            }
            mysql_free_result(result);
        }
    }

    // Close the connection and end MySQL library usage
    mysql_close(con);
    mysql_library_end();

    return 0;
}