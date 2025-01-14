#include <stdio.h>

typedef struct some_struct {
    // ...snip...
    int type;
} some_struct_t;

#define NODE 0
#define REAL 1

int main() {
    some_struct_t my_struct;
    my_struct.type = NODE;
    
    printf("Type of my_struct: %d\n", my_struct.type);
    
    return 0;
}