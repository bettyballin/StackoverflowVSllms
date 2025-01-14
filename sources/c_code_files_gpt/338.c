#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define ALPHABET_SIZE 256

typedef struct RadixNode {
    struct RadixNode *children[ALPHABET_SIZE];
    int is_end_of_word;
} RadixNode;

RadixNode *create_node() {
    RadixNode *node = (RadixNode *)malloc(sizeof(RadixNode));
    if (node) {
        node->is_end_of_word = 0;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            node->children[i] = NULL;
        }
    }
    return node;
}

void insert(RadixNode *root, const char *key) {
    RadixNode *node = root;
    for (int i = 0; key[i] != '\0'; i++) {
        int index = (unsigned char)key[i];
        if (!node->children[index]) {
            node->children[index] = create_node();
        }
        node = node->children[index];
    }
    node->is_end_of_word = 1;
}

int search(RadixNode *root, const char *key) {
    RadixNode *node = root;
    for (int i = 0; key[i] != '\0'; i++) {
        int index = (unsigned char)key[i];
        if (!node->children[index]) {
            return 0;
        }
        node = node->children[index];
    }
    return (node != NULL && node->is_end_of_word);
}

void free_radix_tree(RadixNode *node) {
    if (!node) {
        return;
    }
    for (int i = 0; i < ALPHABET_SIZE; i++) {
        free_radix_tree(node->children[i]);
    }
    free(node);
}

int main() {
    RadixNode *root = create_node();
    insert(root, "example");
    printf("Search for 'example': %s\n", search(root, "example") ? "Found" : "Not Found");
    free_radix_tree(root);
    return 0;
}