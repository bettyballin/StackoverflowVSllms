#include <stdio.h>
#include <stdlib.h>

typedef enum {
    NODE,
    REAL
} Type;

typedef struct somestruct {
    Type type;
} somestruct;

int main() {
    somestruct* something = malloc(sizeof(somestruct));

    if (something == NULL) {
        printf("Memory allocation failed\n");
        return 1;
    }

    something->type = NODE;

    switch (something->type) {
        case NODE:
            printf("Type is NODE\n");
            break;
        case REAL:
            printf("Type is REAL\n");
            break;
    }

    free(something);
    return 0;
}