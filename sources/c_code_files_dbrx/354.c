#include <mysql/mysql.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    MYSQL *sqlhn = mysql_init(NULL);
    if (sqlhn != NULL) {
        mysql_real_connect(sqlhn, "server", "user", "pass", "database", 0, NULL, 0);

        if (sqlhn->host != NULL && sqlhn->port != 0U){
            MYSQL_RES *configRes; /* result set */
            unsigned int numFields = 0U; /* number of fields in the table*/
            MYSQL_ROW row;      /* a single row from a result set returned by mysql_fetch_row(3) */
            MYSQL_FIELD *fields;
            if (mysql_query(sqlhn, "SELECT * FROM `my_table`")) {
                printf("Error: %s\n", sqlhn->error);
                exit(-1);
            } else {
                configRes = mysql_store_result(sqlhn);    /* allocate memory to hold result set */
                numFields = mysql_num_fields(configRes);  /* get the number of fields in table */
                fields = mysql_fetch_fields(configRes);/* pointer to field names array stored in configRes*/
            }
            while((row = mysql_fetch_row(configRes))){     /* fetch each row, and loop through fields */
                for (int i = 0 ; i < numFields; ++i) {      /* column name can be got using field names array */
                   printf("column=%s value=%s\n",fields[i].name,row[i]); // You just print out. To store in a variable, modify according to your use case
                }
            }
            mysql_free_result(configRes); /* free memory allocated to configRes */
        } else {
             printf("Failed connecting\n");
             return -1;
        }
        mysql_close(sqlhn);
    } else {
        printf("Unable to init connection\n");
        return -1;
    }
    return 0;
}