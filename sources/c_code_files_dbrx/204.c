#include <stdio.h>
#include <stdlib.h>

int main() {
    int n;
    scanf("%d", &n);

    char* b = malloc(10 * sizeof(char)); // allocate memory for the string

    for (int i = 0; i < n; i++) {
        sprintf(b, "%d", i);
        printf("%s\n", b);
    }

    free(b); // don't forget to free the memory

    return 0;
}