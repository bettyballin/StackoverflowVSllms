#include <stdlib.h>

typedef struct bucket {
    // assuming some definition for bucket
} bucket;

typedef struct hash_table {
    size_t size;
    bucket** table;
} hash_table;

hash_table* init_table(size_t size) {
    size_t i;
    hash_table* ht = (hash_table*)malloc(sizeof(hash_table));
    if (ht == NULL) return NULL;
    ht->size = size;
    ht->table = (bucket**)malloc(sizeof(bucket*)*size);
    if (ht->table == NULL) {
        free(ht);
        return NULL;
    }
    for (i = 0; i < size; ++i) {
        ht->table[i] = NULL;
    }
    return ht;
}