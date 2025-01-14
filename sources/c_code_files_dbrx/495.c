#include <stdio.h>
#include <stdlib.h>

// Define the structure for a tree node
typedef struct TreeType {
    int data;
    struct TreeType* left;
    struct TreeType* right;
} TreeType;

// Function to create a new tree node
TreeType* createNode(int data) {
    TreeType* newNode = (TreeType*) malloc(sizeof(TreeType));
    if (!newNode) {
        printf("Memory error\n");
        return NULL;
    }
    newNode->data = data;
    newNode->left = newNode->right = NULL;
    return newNode;
}

// Function to create a sample binary tree
TreeType* createTree() {
    TreeType* root = createNode(1);
    root->left = createNode(2);
    root->right = createNode(3);
    root->left->left = createNode(4);
    root->left->right = createNode(5);
    root->right->left = createNode(6);
    root->right->right = createNode(7);
    return root;
}

// Function to draw the tree
void draw_node(TreeType* node, int indent) {
    if (node != NULL) {
        draw_node(node->right, indent + 4);
        for (int i = 0; i < indent; i++) {
            printf(" ");
        }
        printf("%d\n", node->data);
        draw_node(node->left, indent + 4);
    }
}

int main() {
    TreeType* root = createTree();
    draw_node(root, 0);
    return 0;
}