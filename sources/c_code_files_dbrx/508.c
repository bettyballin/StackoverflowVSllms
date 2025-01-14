#include <stdio.h>
#include <math.h>
#include <stdlib.h>

// Define the TreeType struct
typedef struct TreeType {
    int data;
    struct TreeType* left;
    struct TreeType* right;
} TreeType;

// Function to create a new tree node
TreeType* create_node(int data) {
    TreeType* node = (TreeType*) malloc(sizeof(TreeType));
    node->data = data;
    node->left = NULL;
    node->right = NULL;
    return node;
}

void draw_node(TreeType* root, int level) {
    // Check for null case
    if (root == NULL)
        return;

    printf("%d\n", root->data);   // Print the value in current node

    draw_node(root->right, level+1);  // Call draw on right child of this node with increased indentation ('level')

    /* This is a bit tricky. You might want to have extra spaces to align your children based upon data size. To do that, you can use some constant value in place of (2*(pow(2, level-1))) */
    for(int i = 0; i < pow(2, level); ++i) {
        printf(" "); // print 'n' spaces where n is based upon the current level of indentation.
    }
    draw_node(root->left, level+1);   // Call draw on left child of this node with increased indentation ('level')
}

int main() {
    // Create a sample tree
    TreeType* root = create_node(1);
    root->left = create_node(2);
    root->right = create_node(3);
    root->left->left = create_node(4);
    root->left->right = create_node(5);
    root->right->left = create_node(6);
    root->right->right = create_node(7);

    // Call the draw_node function
    draw_node(root, 0);

    return 0;
}