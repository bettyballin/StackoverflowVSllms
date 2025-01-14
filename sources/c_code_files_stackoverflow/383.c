#include <stdio.h>
#include <stdlib.h>

// Define the structure for a node in the binary tree
typedef struct node {
    int left_count;
    struct node* left;
    struct node* right;
} node;

// Function to find a node at a given index in the binary tree
node* find_index(node* root, int i) {
    while (root) {
        if (i == root->left_count)
            return root;
        else if (i < root->left_count)
            root = root->left;
        else {
            i -= root->left_count + 1;
            root = root->right;
        }
    }
    return NULL; // i > number of nodes
}

int main() {
    // Example usage:
    node* root = (node*) malloc(sizeof(node));
    root->left_count = 2;
    root->left = (node*) malloc(sizeof(node));
    root->right = (node*) malloc(sizeof(node));
    root->left->left_count = 0;
    root->left->left = NULL;
    root->left->right = NULL;
    root->right->left_count = 0;
    root->right->left = NULL;
    root->right->right = NULL;

    node* found_node = find_index(root, 1);
    if (found_node)
        printf("Found node at index 1 with left count %d\n", found_node->left_count);
    else
        printf("Node not found at index 1\n");

    free(root->left);
    free(root->right);
    free(root);

    return 0;
}