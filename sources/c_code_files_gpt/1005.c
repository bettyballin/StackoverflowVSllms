#include <ecpglib.h>
#include <ecpgerrno.h>
#include <sqlca.h>
#include <stdlib.h>
#include <stdio.h>

#define INT_ARR_NULL -1

struct foobar {
    int *foo;
    int *bar;
};

void init_foobar(struct foobar *fb) {
    fb->foo = (int*) calloc(11, sizeof(int));
    fb->bar = (int*) calloc(11, sizeof(int));
    fb->foo[10] = INT_ARR_NULL;
    fb->bar[10] = INT_ARR_NULL;
    for (int i = 0; i < 10; ++i) {
        fb->foo[i] = i;
        fb->bar[i] = i;
    }
}

void array_to_string(int *array, char *str) {
    char buffer[12];
    int *cursor = array;
    str[0] = '\0';
    strcat(str, "{");
    while (*cursor != INT_ARR_NULL) {
        sprintf(buffer, "%d", *cursor);
        strcat(str, buffer);
        cursor++;
        if (*cursor != INT_ARR_NULL) {
            strcat(str, ",");
        }
    }
    strcat(str, "}");
}

void insert_into_db(struct foobar *fb) {
    char foo_str[256] = {0};
    char bar_str[256] = {0};

    array_to_string(fb->foo, foo_str);
    array_to_string(fb->bar, bar_str);

    EXEC SQL BEGIN DECLARE SECTION;
    char *foo_array = foo_str;
    char *bar_array = bar_str;
    EXEC SQL END DECLARE SECTION;

    EXEC SQL CONNECT TO mydb USER myuser PASSWORD mypassword;

    EXEC SQL WHENEVER SQLERROR SQLPRINT;

    EXEC SQL INSERT INTO mytable (foo_column, bar_column) VALUES (:foo_array, :bar_array);

    EXEC SQL COMMIT;

    EXEC SQL DISCONNECT;
}

int main() {
    struct foobar fb;
    init_foobar(&fb);
    insert_into_db(&fb);

    free(fb.foo);
    free(fb.bar);

    return 0;
}