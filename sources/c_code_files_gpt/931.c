#include <stdio.h>
#include <stdlib.h>
#include <sqlite3.h>

// Function to output XML start
void start_xml() {
    printf("Content-type: text/xml\n\n");
    printf("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
    printf("<data>\n");
}

// Function to output XML end
void end_xml() {
    printf("</data>\n");
}

// Function to output a single row of XML
void output_row(const char *column1, const char *column2) {
    printf("  <row>\n");
    printf("    <column1>%s</column1>\n", column1);
    printf("    <column2>%s</column2>\n", column2);
    printf("  </row>\n");
}

int main(void) {
    sqlite3 *db;
    sqlite3_stmt *res;
    int rc;

    // Open the SQLite database
    rc = sqlite3_open("your_database.db", &db);
    if (rc != SQLITE_OK) {
        fprintf(stderr, "Cannot open database: %s\n", sqlite3_errmsg(db));
        return 1;
    }

    // Prepare the SQL statement
    rc = sqlite3_prepare_v2(db, "SELECT column1, column2 FROM your_table", -1, &res, 0);
    if (rc != SQLITE_OK) {
        fprintf(stderr, "Failed to fetch data: %s\n", sqlite3_errmsg(db));
        sqlite3_close(db);
        return 1;
    }

    // Start the XML output
    start_xml();

    // Execute the SQL statement and generate XML rows
    while (sqlite3_step(res) == SQLITE_ROW) {
        const char *column1 = (const char *)sqlite3_column_text(res, 0);
        const char *column2 = (const char *)sqlite3_column_text(res, 1);

        output_row(column1, column2);
    }

    // End the XML output
    end_xml();

    // Clean up
    sqlite3_finalize(res);
    sqlite3_close(db);

    return 0;
}