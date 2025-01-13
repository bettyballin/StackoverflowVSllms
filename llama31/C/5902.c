// radix.c\n\n#include <stdio.h>\n#include <stdlib.h>\n#include <string.h>\n#include <stdint.h>\n\n// Structure to represent a radix node\ntypedef struct radix_node {\n    void *data;\n    struct radix_node *child[2];\n} radix_node_t;\n\n// Structure to represent a radix tree\ntypedef struct radix_tree {\n    radix_node_t *root;\n} radix_tree_t;\n\n// Function to create a new radix node\nstatic radix_node_t *radix_node_create(void) {\n    radix_node_t *node = malloc(sizeof(radix_node_t));\n    if (node) {\n        node->data = NULL;\n        node->child[0] = NULL;\n        node->child[1] = NULL;\n    }\n    return node;\n}\n\n// Function to create a new radix tree\nradix_tree_t *radix_tree_create(void) {\n    radix_tree_t *tree = malloc(sizeof(radix_tree_t));\n    if (tree) {\n        tree->root = radix_node_create();\n    }\n    return tree;\n}\n\n// Function to insert a key into the radix tree\nint radix_tree_insert(radix_tree_t *tree, uint32_t key, void *data) {\n    radix_node_t *node = tree->root;\n    for (int i = 31; i >= 0; i--) {\n        int bit = (key >> i) & 1;\n        if (!node->child[bit]) {\n            node->child[bit] = radix_node_create();\n        }\n        node = node->child[bit];\n    }\n    node->data = data;\n    return 0;\n}\n\n// Function to search for a key in the radix tree\nvoid *radix_tree_search(radix_tree_t *tree, uint32_t key) {\n    radix_node_t *node = tree->root;\n    for (int i = 31; i >= 0; i--) {\n        int bit = (key >> i) & 1;\n        if (!node->child[bit]) {\n            return NULL;\n        }\n        node = node->child[bit];\n    }\n    return node->data;\n}\n\nint main() {\n    radix_tree_t *tree = radix_tree_create();\n    radix_tree_insert(tree, 0x12345678, "Hello, World!");\n    void *data = radix_tree_search(tree, 0x12345678);\n    if (data) {\n        printf("%s\n", (char *)data);\n    }\n    return 0;\n}