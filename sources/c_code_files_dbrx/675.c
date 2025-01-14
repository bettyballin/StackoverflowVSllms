#include <stdio.h>
#include <stdlib.h>

#define ALPHABET_SIZE 26

// Define the structure for a node in the Trie
typedef struct Node {
    struct Node *child[ALPHABET_SIZE];
    int isLeaf;
} Node;

// Function to create a new Trie node
Node* newNode() {
    Node* node = (Node*)malloc(sizeof(Node));
    if (node) {
        node->isLeaf = 0;
        for (int i = 0; i < ALPHABET_SIZE; i++)
            node->child[i] = NULL;
    }
    return node;
}

int count = 0; // To keep track of the count of paths found
int m = 0; // Minimum depth to consider a path

// A recursive function used by countPaths()
void dfsUtil(Node *root, int depth) {
    /* Reached a leaf node and depth is greater or equal to m. Increment count of path found from the root node to this leaf */
    if (root->isLeaf && depth >= m) {
        count++;
        return;
    }

    // Do DFS for all children characters of TrieNode 'node'
    for(int i = 0; i < ALPHABET_SIZE; i++) {
        if (root->child[i] != NULL)
            dfsUtil(root->child[i], depth + 1);
    }
}

int main() {
    // Example usage
    Node* root = newNode();
    root->child[0] = newNode(); // 'a'
    root->child[0]->child[0] = newNode(); // 'aa'
    root->child[0]->child[0]->isLeaf = 1;

    m = 2; // Set minimum path length

    dfsUtil(root, 0);

    printf("Count of paths with depth >= %d: %d\n", m, count);

    return 0;
}