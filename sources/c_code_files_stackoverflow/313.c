#include <mysql/mysql.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    MYSQL *sqlhnd = mysql_init(NULL);
    if (sqlhnd == NULL) {
        fprintf(stderr, "mysql_init failed\n");
        exit(1);
    }

    if (mysql_real_connect(sqlhnd, "localhost", "username", "password", "database", 0, NULL, 0) == NULL) {
        fprintf(stderr, "mysql_real_connect failed: %s\n", mysql_error(sqlhnd));
        mysql_close(sqlhnd);
        exit(1);
    }

    if (mysql_query(sqlhnd, "SELECT * FROM `my_table`")) {
        fprintf(stderr, "mysql_query failed: %s\n", mysql_error(sqlhnd));
        mysql_close(sqlhnd);
        exit(1);
    }

    MYSQL_RES *confres = mysql_store_result(sqlhnd);
    if (confres == NULL) {
        fprintf(stderr, "mysql_store_result failed: %s\n", mysql_error(sqlhnd));
        mysql_close(sqlhnd);
        exit(1);
    }

    int totalrows = mysql_num_rows(confres);
    int numfields = mysql_num_fields(confres);
    MYSQL_FIELD *mfield;
    MYSQL_ROW row;
    int i;

    printf("Total rows: %d, Total fields: %d\n", totalrows, numfields);

    while((row = mysql_fetch_row(confres)))
    {
        for(i = 0; i < numfields; i++)
        {
            char *val = row[i];
            printf("Value for field %d: %s\n", i, val);
            // do something with val...
        }
    }

    mysql_free_result(confres);
    mysql_close(sqlhnd);

    return 0;
}