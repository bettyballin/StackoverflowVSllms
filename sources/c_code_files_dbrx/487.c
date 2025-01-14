#include <mpg123.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    mpg123_handle *mh;
    mpg123_init();
    mh = mpg123_new(NULL, &mpg123_errors);

    if (mh == NULL) {
        printf("mpg123_new failed\n");
        return 1;
    }

    mpg123_close(mh);
    mpg123_delete(mh);
    mpg123_exit();

    return 0;
}