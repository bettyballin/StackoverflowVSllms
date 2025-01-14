#include <tcutil.h>
#include <tchdb.h>
#include <stdlib.h>
#include <stdio.h>

int main() {
    // Create a new database object
    TCHDB *hdb = tchdbnew();

    // Open the database
    if (!tchdbopen(hdb, "mydatabase.tch", HDBOWRITER | HDBOCREAT)) {
        int ecode = tchdbecode(hdb);
        fprintf(stderr, "open error: %s\n", tchdberrmsg(ecode));
        return -1;
    }

    // Store a record
    if (!tchdbput2(hdb, "key", "value")) {
        int ecode = tchdbecode(hdb);
        fprintf(stderr, "put error: %s\n", tchdberrmsg(ecode));
    }

    // Retrieve a record
    const char *value = tchdbget2(hdb, "key");
    if (value) {
        printf("value: %s\n", value);
        free((void *)value);
    } else {
        int ecode = tchdbecode(hdb);
        fprintf(stderr, "get error: %s\n", tchdberrmsg(ecode));
    }

    // Close the database
    if (!tchdbclose(hdb)) {
        int ecode = tchdbecode(hdb);
        fprintf(stderr, "close error: %s\n", tchdberrmsg(ecode));
    }

    // Delete the database object
    tchdbdel(hdb);

    return 0;
}