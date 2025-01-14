#include <stdio.h>

typedef struct Node {
    struct Node* p_member;
    int member;
} Node;

int main() {
    Node node1 = { NULL, 1 };
    Node node2 = { &node1, 2 };
    Node node3 = { &node2, 3 };
    Node* p_member = &node3;

    // Syntax #1
    int value1 = (*(*(*p_member).p_member).p_member).member;
    printf("Value (Syntax #1): %d\n", value1);

    // Syntax #2
    int value2 = p_member->p_member->p_member->member;
    printf("Value (Syntax #2): %d\n", value2);

    return 0;
}