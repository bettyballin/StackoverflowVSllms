#include <stdio.h>

typedef enum somestruct_type {
    somestruct_type_NODE, 
    somestruct_type_REAL
} somestruct_type;

typedef struct somestruct {
    // ...snip...
    somestruct_type type;
} somestruct;

int main() {
    // You can add your own test code here
    somestruct s;
    s.type = somestruct_type_NODE;
    printf("%d\n", s.type);
    return 0;
}