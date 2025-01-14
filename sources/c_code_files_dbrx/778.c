#include <stdio.h>
#include <string.h>

// Define missing constants
#define MAX_NAME 256
#define MAX_PATH 1024
#define T 5 // Define T as an example

typedef struct {
    char name[MAX_NAME];
    char path[MAX_PATH];
} Record;

#define MAX (1 + 2 * T) // max degree of B-tree is O(t). Node will have between t-1 and 2t records.
typedef struct {
    int numKeys;            /* number of keys in the node */
    Record key[MAX];   /* array for storing keys, each also a file location here*/
} BTreeNode;

int main() {
    // Create a BTreeNode
    BTreeNode node;
    node.numKeys = 0;

    // Example: populate the first Record in the node
    strcpy(node.key[0].name, "example_name");
    strcpy(node.key[0].path, "/path/to/example");
    node.numKeys++;

    printf("Created a BTreeNode with %d key(s).\n", node.numKeys);
    printf("Name of the first key: %s\n", node.key[0].name);
    printf("Path of the first key: %s\n", node.key[0].path);

    return 0;
}