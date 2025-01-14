// ast.h
#ifndef AST_H
#define AST_H

typedef struct ASTNode {
    int nodetype;
    struct ASTNode *left;
    struct ASTNode *right;
    /* You can add more fields as needed */
} ASTNode;

#endif  // AST_H