#include <stdio.h>
#include <dbi/dbi.h>

int main() {
    dbi_conn conn;
    int rows_processed = 0;

    /* initialise library */
    if (dbi_initialize(NULL) == -1) {
        return -1;
    }

    // Create a connection using your data source name, username and password.
    conn = dbi_connect("DBI:mysql:host=localhost", "username", "password", NULL);
    if (dbi_conn_error(conn) != DBI_ERROR_NONE) {
        return -1;
    }

    // Execute query statement.
    rows_processed = dbi_query(conn, "SELECT * FROM EMP");
    if (rows_processed == -1) {
         fprintf(stderr, "Query error\n");
         dbi_shutdown();
         return -2;
     }

    // Print each row.
    while (dbi_fetch_row(conn)) {
        int i;
        for (i = 0 ; i<dbi_num_fields(conn) ; ++i) {
            printf("%s ", dbi_row_get(conn, i));
        }
        printf("\n");
    }

    // Free up resources.
    dbi_free_result(conn);
    dbi_close(conn);
    dbi_shutdown();
    return 0;
}