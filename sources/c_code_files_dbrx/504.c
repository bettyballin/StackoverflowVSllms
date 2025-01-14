#include <stdlib.h>

// Assuming ht is a struct with a table field that is an array of pointers
typedef struct {
    void* table[101];
} hash_table;

int main() {
    hash_table* ht = malloc(sizeof(hash_table));
    if (ht == NULL) {
        return 1; // Memory allocation failed
    }

    // Initialize table to NULL
    for (int i = 0; i < 101; i++) {
        ht->table[i] = NULL;
    }

    // ... other code that uses ht ...

    // Free each bucket allocated memory
    for (int i = 0; i < 101; i++) {
        if (ht->table[i] != NULL) {
            free(ht->table[i]);
        }
    }

    // Finally, deallocate hash_table and reset pointer to null to avoid stale pointers
    free((void*) ht);
    ht = NULL;

    return 0;
}