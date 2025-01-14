#include <stdio.h>
#include <string.h>

int main() {
    char sql[256]; // Buffer for SQL query
    char* offset = "50"; // Example offset

    // Ensure the buffer is large enough for the SQL query and the offset value
    sprintf(sql, "SELECT * FROM Customer_Table ORDER BY age_ID LIMIT 100 OFFSET %s;", offset);

    // Print the constructed SQL query
    printf("%s\n", sql);

    return 0;
}