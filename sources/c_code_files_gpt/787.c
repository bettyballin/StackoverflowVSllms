#include <stdio.h>

// Define a struct to match the expression
typedef struct {
    int member;
    struct {
        int member;
        struct {
            int member;
        } *p_member;
    } *p_member;
} MyStruct;

int main() {
    // Create an instance of the struct
    MyStruct myStruct;
    myStruct.p_member = malloc(sizeof(*myStruct.p_member));
    myStruct.p_member->p_member = malloc(sizeof(*myStruct.p_member->p_member));

    // Initialize the member variable
    (*(*(*myStruct.p_member).p_member).p_member).member = 10;

    // Print the value of the member variable
    printf("%d\n", (*(*(*myStruct.p_member).p_member).p_member).member);

    // Free the allocated memory
    free(myStruct.p_member->p_member);
    free(myStruct.p_member);

    return 0;
}