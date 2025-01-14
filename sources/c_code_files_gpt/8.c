#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    char *query_string = getenv("QUERY_STRING");
    int offset = 0;

    if (query_string != NULL) {
        char *offset_str = strstr(query_string, "offset=");
        if (offset_str != NULL) {
            offset = atoi(offset_str + 7);
        }
    }

    // Ensure offset is a multiple of 100 and non-negative
    if (offset < 0) {
        offset = 0;
    }

    // Make offset a multiple of 100
    offset = (offset / 100) * 100;

    // Use the offset in your SQL query
    printf("Content-type: text/html\n\n");
    printf("Current OFFSET: %d\n", offset);

    // Example SQL query
    char sql_query[256];
    snprintf(sql_query, sizeof(sql_query), "SELECT * FROM your_table ORDER BY some_column LIMIT 100 OFFSET %d;", offset);
    printf("SQL Query: %s\n", sql_query);

    // Your database query execution code here

    return 0;
}