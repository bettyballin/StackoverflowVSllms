// ast.c
#include <stdlib.h>

// Define the ASTNode struct
typedef struct ASTNode {
    int nodetype;
    struct ASTNode* left;
    struct ASTNode* right;
} ASTNode;

ASTNode* createNode(int nodetype, ASTNode* left, ASTNode* right) {
    ASTNode* node = (ASTNode*)malloc(sizeof(ASTNode));
    if (!node) {
        // Handle memory allocation failure
        return NULL;
    }
    node->nodetype = nodetype;
    node->left = left;
    node->right = right;
    return node;
}