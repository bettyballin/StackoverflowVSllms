#include <stdio.h>
#include <stdlib.h>

// Define the structure for a Trie node
typedef struct Node {
    struct Node *children[26]; // Assuming 26 English alphabets
    int isEndOfWord;
} Node;

// Function to create a new Trie node
Node *createNode() {
    Node *node = (Node *) malloc(sizeof(Node));
    for (int i = 0; i < 26; i++) {
        node->children[i] = NULL;
    }
    node->isEndOfWord = 0;
    return node;
}

// Utility function for depth-first search
void dfsUtil(Node *root, int depth) {
    if (root == NULL) {
        return;
    }

    if (root->isEndOfWord == 1) {
        printf("Found a path of length %d\n", depth);
    }

    for (int i = 0; i < 26; i++) {
        if (root->children[i] != NULL) {
            dfsUtil(root->children[i], depth + 1);
        }
    }
}

// Function to count all possible Trie paths
void countPaths(Node *root) {
    dfsUtil(root, 0);
}

int main() {
    // Create a sample Trie
    Node *root = createNode();
    root->children[0] = createNode(); // 'a'
    root->children[0]->children[1] = createNode(); // 'b'
    root->children[0]->children[1]->isEndOfWord = 1;

    // Count all possible Trie paths
    countPaths(root);

    return 0;
}