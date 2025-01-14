#include <stdio.h>

struct Foo {
    int values[20];
};

int main() {
    struct Foo foo;
    int values[20];
    
    printf("Size of foo.values: %zu\n", sizeof(foo.values));
    printf("Size of values: %zu\n", sizeof(values));
    
    if (sizeof(foo.values) == sizeof(values)) {
        printf("The sizes are equal.\n");
    } else {
        printf("The sizes are not equal.\n");
    }

    return 0;
}