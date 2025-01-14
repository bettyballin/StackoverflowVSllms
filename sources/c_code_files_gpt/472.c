#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TYPE_A 1
#define TYPE_B 2

typedef struct {
    int type_id;
    // other members
} TypeBase;

typedef struct {
    int type_id;
    int a;
    // other members
} TypeA;

typedef struct {
    int type_id;
    char b;
    // other members
} TypeB;

void* allocate_type(int type_id) {
    if (type_id == TYPE_A) {
        TypeA* ptr = malloc(sizeof(TypeA));
        ptr->type_id = TYPE_A;
        return ptr;
    } else if (type_id == TYPE_B) {
        TypeB* ptr = malloc(sizeof(TypeB));
        ptr->type_id = TYPE_B;
        return ptr;
    }
    return NULL;
}

int get_type(void* ptr) {
    TypeBase* base = (TypeBase*)ptr;
    return base->type_id;
}

int main() {
    TypeA* a = (TypeA*)allocate_type(TYPE_A);
    TypeB* b = (TypeB*)allocate_type(TYPE_B);

    printf("Type of a: %d\n", get_type(a)); // Output: Type of a: 1
    printf("Type of b: %d\n", get_type(b)); // Output: Type of b: 2

    free(a);
    free(b);

    return 0;
}