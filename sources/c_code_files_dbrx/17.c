#include <sqlite3.h>
#include <stdio.h>

int main(int argc, char* argv[]) {
    sqlite3* db;
    char* errorMessage;

    // Attempt to open the database
    int rc = sqlite3_open("test.db", &db);
    
    if(rc) {
        fprintf(stderr, "Can't open database: %s\n", sqlite3_errmsg(db));
        return(1);
    } else {
        fprintf(stderr, "Opened database successfully\n");
    }

    // Close the database
    sqlite3_close(db);
    return 0;
}