#include <stdio.h>
#include <sqlite3.h>
#include <stdlib.h> // for exit()

static int callback(void *data, int argc, char **argv, char **azColName) {
    int i;
    fprintf(stderr, "%s: ", (const char*)data);
    for(i = 0; i<argc; i++) {
        printf("%s = %s\n", azColName[i], argv[i] ? argv[i] : "NULL");
    }
    printf("\n");
    return 0;
}

int main() {
  sqlite3 *db;
  char *zErrMsg = 0;
  int rc;

  rc = sqlite3_open("test.db", &db);
  if( rc ) {
     fprintf(stderr, "Can't open database: %s\n", sqlite3_errmsg(db));
     exit(1); // Changed to exit(1) to indicate failure
  } else {
    fprintf(stdout, "Opened database successfully\n");
    sqlite3_close(db);
  }
  return 0;
}