#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char *bar;
} Foo;

int main() {
    Foo *foo = malloc(sizeof(Foo));
    foo->bar = NULL;

    if (foo->bar == NULL) {
        foo->bar = strdup("Unknown");
    }

    printf("%s\n", foo->bar);

    free(foo->bar);
    free(foo);

    return 0;
}