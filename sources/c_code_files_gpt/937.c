#include <stdio.h>
#include <stdlib.h>

// Define the structure for a Node
typedef struct Node {
    int data;
    struct Node* left;
    struct Node* right;
} Node;

// Function to create a new Node
Node* createNode(int data) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    if (!newNode) {
        printf("Memory error\n");
        return NULL;
    }
    newNode->data = data;
    newNode->left = newNode->right = NULL;
    return newNode;
}

// Function to perform right rotation
Node* rightRotate(Node* node) {
    Node* temp = node->left;
    node->left = temp->right;
    temp->right = node;
    return temp;
}

// Function to perform left rotation
Node* leftRotate(Node* node) {
    Node* temp = node->right;
    node->right = temp->left;
    temp->left = node;
    return temp;
}

// Your original function
Node* rightLeftRotate(Node* z) {
    z->right = rightRotate(z->right);
    return leftRotate(z);
}

int main() {
    // Example usage:
    Node* root = createNode(1);
    root->right = createNode(2);
    root->right->left = createNode(3);
    root = rightLeftRotate(root);
    return 0;
}