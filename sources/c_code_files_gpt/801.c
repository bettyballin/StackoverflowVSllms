#include <assert.h>
#include <stdbool.h>
#include <stdlib.h>

// Define a structure for the free list node
typedef struct FreeListNode {
    size_t size;
    struct FreeListNode* next;
} FreeListNode;

// Assume we have a global free list
FreeListNode* free_list = NULL;

void my_free(void* ptr) {
    // Your free implementation
    assert(free_list_invariant());
}

bool free_list_invariant() {
    // Check that the free list is correctly coalesced and sorted
    // Return true if invariant holds, false otherwise
    FreeListNode* current = free_list;
    FreeListNode* next = NULL;

    while (current != NULL) {
        next = current->next;
        if (next != NULL && current + current->size != next) {
            // Check for coalescing
            return false;
        }
        if (next != NULL && current->size > next->size) {
            // Check for sorting
            return false;
        }
        current = next;
    }

    return true;
}

int main() {
    // Create a dummy node to test the invariant
    FreeListNode* node = malloc(sizeof(FreeListNode));
    node->size = 10;
    node->next = NULL;
    free_list = node;

    my_free(NULL);

    return 0;
}