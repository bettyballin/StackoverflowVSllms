#pragma GCC diagnostic push
#pragma GCC diagnostic ignored "-Wdeprecated-declarations"

#include <stdio.h>
#include <stdlib.h>

int main() {
    char *dir = tempnam(NULL, "prefix");
    if (dir) {
        printf("Temporary directory name: %s\n", dir);
        free(dir);
    } else {
        perror("tempnam");
    }
    return 0;
}

#pragma GCC diagnostic pop