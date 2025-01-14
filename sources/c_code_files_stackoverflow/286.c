#include <sqlite3.h>

int main() {
    // Call the sqlite3_blob_write function
    sqlite3* db;
    sqlite3_blob* blob;
    void* data = "Hello, World!";
    int size = 13;
    int offset = 0;

    // Open a connection to the database
    sqlite3_open("example.db", &db);

    // Create a blob
    sqlite3_blob_open(db, "main", "example", "data", 1, 0, &blob);

    // Write to the blob
    int result = sqlite3_blob_write(blob, data, size, offset);

    // Close the blob and database
    sqlite3_blob_close(blob);
    sqlite3_close(db);

    return result;
}