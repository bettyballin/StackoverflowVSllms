#include <stdio.h>
#include <stdlib.h>

struct node {
    int key1;
    int key2;
    struct node* left;
    struct node* right;
};

// Utility function to create a new BST node
struct node* newNode(int key1, int key2) {
    struct node* temp = (struct node*)malloc(sizeof(struct node));
    temp->key1 = key1;
    temp->key2 = key2;
    temp->left = temp->right = NULL;
    return temp;
}

// Utility function for in-order traversal
void storeInOrder(struct node* root, struct node** arr, int* index) {
    if (root == NULL)
        return;

    storeInOrder(root->left, arr, index);
    arr[(*index)++] = root;
    storeInOrder(root->right, arr, index);
}

// Comparator function for sorting nodes by key2
int compare(const void* a, const void* b) {
    return (*(struct node**)a)->key2 - (*(struct node**)b)->key2;
}

// Utility function to build a balanced BST from sorted array
struct node* buildBST(struct node** arr, int start, int end) {
    if (start > end)
        return NULL;

    int mid = (start + end) / 2;
    struct node* root = arr[mid];
    root->left = buildBST(arr, start, mid - 1);
    root->right = buildBST(arr, mid + 1, end);

    return root;
}

// Function to rearrange BST based on key2
struct node* rearrangeOnKey2(struct node* root) {
    if (root == NULL)
        return NULL;

    int n = 0;
    struct node* temp = root;
    while (temp != NULL) { // Count nodes
        n++;
        temp = temp->left;
    }

    // FIX: Also count nodes in the right subtree
    temp = root->right;
    while (temp != NULL) {
        n++;
        temp = temp->left;
    }

    struct node** arr = (struct node**)malloc(n * sizeof(struct node*));
    int index = 0;
    storeInOrder(root, arr, &index);

    qsort(arr, n, sizeof(struct node*), compare);

    return buildBST(arr, 0, n - 1);
}

// Helper function to print in-order traversal of the BST
void inorder(struct node* root) {
    if (root != NULL) {
        inorder(root->left);
        printf("%d %d\n", root->key1, root->key2);
        inorder(root->right);
    }
}

// Driver code
int main() {
    struct node* root = newNode(5, 20);
    root->left = newNode(3, 15);
    root->right = newNode(8, 30);
    root->left->left = newNode(1, 10);
    root->right->left = newNode(7, 25);

    printf("Original BST (in-order):\n");
    inorder(root);

    root = rearrangeOnKey2(root);

    printf("\nBST rearranged by key2 (in-order):\n");
    inorder(root);

    return 0;
}