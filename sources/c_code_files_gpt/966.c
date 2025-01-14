#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct Node {
    int data;
    struct Node* left;
    struct Node* right;
} Node;

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

int height(Node* node) {
    if (node == NULL)
        return 0;
    int leftHeight = height(node->left);
    int rightHeight = height(node->right);
    return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
}

void printLevel(Node* node, int level, int indentSpace) {
    if (node == NULL) {
        printf("%*s", indentSpace, " ");
        return;
    }
    if (level == 1) {
        printf("%*d", indentSpace, node->data);
    } else if (level > 1) {
        printLevel(node->left, level - 1, indentSpace / 2);
        printLevel(node->right, level - 1, indentSpace / 2);
    }
}

void printTree(Node* root) {
    int h = height(root);
    int indentSpace = (int)pow(2, h) - 1;
    for (int i = 1; i <= h; i++) {
        printLevel(root, i, indentSpace);
        printf("\n");
        indentSpace /= 2;
    }
}

int main() {
    Node* root = createNode(5);
    if (root == NULL) {
        printf("Memory error\n");
        return -1;
    }
    root->left = createNode(3);
    if (root->left == NULL) {
        printf("Memory error\n");
        return -1;
    }
    root->right = createNode(8);
    if (root->right == NULL) {
        printf("Memory error\n");
        return -1;
    }
    root->left->left = createNode(2);
    if (root->left->left == NULL) {
        printf("Memory error\n");
        return -1;
    }
    root->left->right = createNode(4);
    if (root->left->right == NULL) {
        printf("Memory error\n");
        return -1;
    }

    printTree(root);

    return 0;
}