#include <stdio.h>
#include <stdlib.h>

struct Node {
    int member;
    struct Node *p_member;
};

int main() {
    struct Node node = {.member=1, .p_member=NULL};
    struct Node *p_first = &node;
    struct Node **p_second = &p_first;
    struct Node ***p_third = &p_second;

    // Create a new node for p_member
    node.p_member = malloc(sizeof(struct Node));
    node.p_member->member = 2;
    node.p_member->p_member = NULL;

    printf("%d\n", (*(**p_third)).p_member->member);  // syntax #1 (pointer dereference)
    printf("%d\n", p_third[0][0]->p_member->member);  // syntax equivalent to #1, but different formatting
    printf("%d\n", (*(*p_third))->p_member->member);  // mixed syntax
    printf("%d\n", ((***p_third)).p_member->member); // alternative pointer dereference syntax (less common)

    free(node.p_member);
    return 0;
}