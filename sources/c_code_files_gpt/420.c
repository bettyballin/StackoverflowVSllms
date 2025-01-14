#include <stdio.h>

// Define the enum for PLUS and MINUS
typedef enum {
    PLUS,
    MINUS
} operation;

// Define the node structure (assuming it's a binary tree node)
typedef struct node {
    operation op;
    struct node* children[2];
} node;

// Define the child function
node* child(node* n, int i) {
    return n->children[i];
}

// Define the interpret function
int interpret(node* n) {
    switch(n->op) {
        case PLUS:
             return interpret(child(n, 0)) + interpret(child(n, 1));
        case MINUS:
             return interpret(child(n, 0)) - interpret(child(n, 1));
        default:
             printf("Unknown operation\n");
             return 0;
    }
}

int main() {
    // Create nodes for testing
    node plus_node;
    plus_node.op = PLUS;
    node* plus_left = (node*) malloc(sizeof(node));
    plus_left->op = PLUS;
    plus_left->children[0] = NULL;
    plus_left->children[1] = NULL;
    node* plus_right = (node*) malloc(sizeof(node));
    plus_right->op = PLUS;
    plus_right->children[0] = NULL;
    plus_right->children[1] = NULL;
    plus_node.children[0] = plus_left;
    plus_node.children[1] = plus_right;

    // Call the interpret function
    int result = interpret(&plus_node);
    printf("Result: %d\n", result);

    free(plus_left);
    free(plus_right);

    return 0;
}