// Example of a hash table\nstruct HashTable {\n    int size;\n    struct HashNode **buckets;\n};\n\nstruct HashNode {\n    int key;\n    void *value;\n    struct HashNode *next;\n};