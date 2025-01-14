#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Define the maximum number of children for each node (assuming ASCII characters)
#define ALPHABET_SIZE 256

// Trie node structure
typedef struct TrieNode {
    struct TrieNode *children[ALPHABET_SIZE];
    int isEndOfTuple;
} TrieNode;

// Function to create a new Trie node
TrieNode* createNode() {
    TrieNode *node = (TrieNode *)malloc(sizeof(TrieNode));
    node->isEndOfTuple = 0;
    for (int i = 0; i < ALPHABET_SIZE; i++) {
        node->children[i] = NULL;
    }
    return node;
}

// Function to insert a tuple into the Trie
void insert(TrieNode *root, const char *tuple) {
    TrieNode *current = root;
    while (*tuple) {
        if (current->children[(unsigned char)*tuple] == NULL) {
            current->children[(unsigned char)*tuple] = createNode();
        }
        current = current->children[(unsigned char)*tuple];
        tuple++;
    }
    current->isEndOfTuple = 1;
}

// Helper function to print matched tuples
void printMatchedTuple(const char *tuple) {
    printf("Matched tuple: (%s)\n", tuple);
}

// Recursive function to search for matches
void searchHelper(TrieNode *root, const char *event, const char *tuple, int tupleIndex) {
    if (root->isEndOfTuple) {
        printMatchedTuple(tuple);
    }

    if (!event[tupleIndex]) return;

    if (root->children[(unsigned char)event[tupleIndex]]) {
        searchHelper(root->children[(unsigned char)event[tupleIndex]], event, tuple, tupleIndex + 1);
    }
}

// Function to search for matches in the event
void search(TrieNode *root, const char *event) {
    for (int i = 0; event[i]; i++) {
        searchHelper(root, event, event + i, 0);
    }
}

// Function to free the Trie memory
void freeTrie(TrieNode *root) {
    for (int i = 0; i < ALPHABET_SIZE; i++) {
        if (root->children[i]) {
            freeTrie(root->children[i]);
        }
    }
    free(root);
}

int main() {
    // Create the Trie root
    TrieNode *root = createNode();

    // Insert tuples into the Trie
    insert(root, "one");
    insert(root, "four");
    insert(root, "three");
    insert(root, "fourfive"); // Concatenate "four" and "five" to form a single string
    insert(root, "six");

    // Event to be matched
    const char *event = "onefourthree";

    // Perform search for matches
    search(root, event);

    // Free the Trie memory
    freeTrie(root);

    return 0;
}