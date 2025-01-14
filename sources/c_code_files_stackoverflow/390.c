#include <stdio.h>
#include <stdlib.h>

typedef struct HeapBlockHeader {
    struct HeapBlockHeader* next;
    struct HeapBlockHeader* prev;
    int size;
} HeapBlockHeader;

int main() {
    // Create a new HeapBlockHeader
    HeapBlockHeader* header = malloc(sizeof(HeapBlockHeader));
    header->next = NULL;
    header->prev = NULL;
    header->size = 1024; // example size

    // Print the header's size
    printf("Header size: %d\n", header->size);

    // Free the allocated memory
    free(header);

    return 0;
}