#include <stdio.h>
#include <stdlib.h>

// Define the Node structure
typedef struct Node {
    int key;
    struct Node* left;
    struct Node* right;
    int height;
} Node;

// Function to get the height of a node
int getHeight(Node* node) {
    if (node == NULL)
        return 0;
    return node->height;
}

// Function to update the height of a node
void updateHeight(Node* node) {
    node->height = 1 + ((getHeight(node->left) > getHeight(node->right)) ? getHeight(node->left) : getHeight(node->right));
}

// Function to create a new node
Node* createNode(int key) {
    Node* node = (Node*)malloc(sizeof(Node));
    if (!node) {
        printf("Memory error\n");
        return NULL;
    }
    node->key = key;
    node->left = node->right = NULL;
    node->height = 1;
    return node;
}

// Function to perform a right rotation
Node* rightRotate(Node* z) {
    Node* y = z->left;
    Node* T3 = y->right;

    // Perform rotation
    y->right = z;
    z->left = T3;

    // Update heights
    updateHeight(z);
    updateHeight(y);

    return y;
}

// Function to perform a left rotation
Node* leftRotate(Node* z) {
    Node* y = z->right;
    Node* T2 = y->left;

    // Perform rotation
    y->left = z;
    z->right = T2;

    // Update heights
    updateHeight(z);
    updateHeight(y);

    return y;
}

// The given function
Node* leftRightRotate(Node* z) {
    z->left = leftRotate(z->left);
    return rightRotate(z);
}

// Function to print the inorder traversal of the tree
void inorderTraversal(Node* root) {
    if (root != NULL) {
        inorderTraversal(root->left);
        printf("%d ", root->key);
        inorderTraversal(root->right);
    }
}

// Example usage
int main() {
    Node* root = createNode(10);
    root->left = createNode(5);
    root->right = createNode(15);
    root->left->left = createNode(2);
    root->left->right = createNode(7);

    printf("Original tree: ");
    inorderTraversal(root);
    printf("\n");

    root = leftRightRotate(root);

    printf("After left-right rotation: ");
    inorderTraversal(root);
    printf("\n");

    return 0;
}