#include <stdio.h>

#define STRUCTMEMBER_PTR(Ptr, Member, Value) ((Ptr)->Member = Value)

typedef struct {
    int x;
} MyStruct;

int main() {
    MyStruct s;
    STRUCTMEMBER_PTR(&s, x, 10);
    printf("%d\n", s.x);
    return 0;
}