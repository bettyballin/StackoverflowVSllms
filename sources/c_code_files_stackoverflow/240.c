#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int value;
    struct Node* left;
    struct Node* right;
} Node;

typedef struct BinarySearchTree {
    Node* root;
} BinarySearchTree;

Node* createNode(int value) {
    Node* newNode = (Node*) malloc(sizeof(Node));
    if (!newNode) {
        printf("Memory error\n");
        return NULL;
    }
    newNode->value = value;
    newNode->left = newNode->right = NULL;
    return newNode;
}

BinarySearchTree* createBinarySearchTree() {
    BinarySearchTree* bst = (BinarySearchTree*) malloc(sizeof(BinarySearchTree));
    if (!bst) {
        printf("Memory error\n");
        return NULL;
    }
    bst->root = NULL;
    return bst;
}

int search(BinarySearchTree* bst, int val) {
    Node* next = bst->root;

    while (next) {
        if (val == next->value) {
            return next->value;
        } else if (val < next->value) {
            next = next->left;
        } else if (val > next->value) {
            next = next->right;
        }
    }

    // not found
    return 0;
}

int main() {
    BinarySearchTree* bst = createBinarySearchTree();
    bst->root = createNode(10);
    bst->root->left = createNode(5);
    bst->root->right = createNode(15);
    bst->root->left->left = createNode(2);
    bst->root->left->right = createNode(7);

    printf("Search result: %d\n", search(bst, 7));

    return 0;
}