#include <stdlib.h> // for malloc
#include <stdio.h>  // for printf

typedef struct bucket {
    // Add your bucket structure members here
} bucket;

typedef struct hash_table {
    size_t size;
    bucket **table;
} hash_table;

int main() {
    // allocate memory for the hash table
    hash_table *ht = (hash_table *)malloc(sizeof(hash_table));
    // ensure that our allocation succeeded and ht is not NULL, you can do whatever error handling fits in your use-case here. This check is always a best practice as malloc call can return null pointer if allocation failed for some reason:
    if (ht == NULL) { 
        printf("Error allocating memory!\n");
        exit(-1); 
    }
    // before using table elements, ensure that enough space has been allocated to it; allocate an array of bucket pointers with the desired size(101 here):
    ht->table = malloc(sizeof(*(ht->table)) * 101); // sizeof(*ptr) gives us correct pointer type for size calculation.
    if (ht->table == NULL) { 
        printf("Error allocating memory!\n");
        free(ht); 
        exit(-1); 
    }
    // initialize the elements in table:
    for (int i = 0; i < 101; i++) 
        ht->table[i] = NULL; // Initialize each pointer to NULL which would later be replaced to valid bucket address when needed.

    return 0;
}