#include <stdio.h>
#include <stdlib.h>

int main() {
    int **multi;
    multi = calloc(10, sizeof(int*));
    multi[5] = calloc(20, sizeof(int));

    multi[5][11] = 66;

    for (int i = 0; i < 10; i++) {
        if (multi[i]) {
            free(multi[i]);
            multi[i] = NULL;
        }
    }

    free(multi);

    return 0;
}