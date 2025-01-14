#include <stdio.h>
#include <stdlib.h>

int main() {
    char *str = NULL;
    size_t len = 0;

    if (getline(&str, &len, stdin) == -1) {
        clearerr(stdin);
        printf("\n");
    }

    free(str);
    return 0;
}