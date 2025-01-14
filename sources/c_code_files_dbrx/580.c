#include <stdbool.h>
#include <stddef.h>

#define TABLE_SIZE 1024

unsigned char* table[TABLE_SIZE] = {NULL}; // Initially all elements are unset
int item_count = 0;

// Hash function - Replace with suitable hash algorithm for C memory addresses
size_t hash(void* addr)
{
    return ((size_t)addr % TABLE_SIZE);
}

bool add(void* addr)
{
    if (item_count >= TABLE_SIZE)
        return false; // Table is full, can't insert more elements
    size_t index = hash(addr);
    while (table[index] != NULL && table[index] != addr)
    {
        ++index;
        if (index == TABLE_SIZE) // Wrapped around to the beginning of the table
            return false; // No free slot
    }
    if (table[index] == NULL) // Empty slot found, insert new element
        item_count++;

    table[index] = addr;
    return true;
}

void remove(void* addr)
{
    size_t index = hash(addr);
    while (table[index] != NULL && table[index] != addr)
    {
        ++index;
        if (index == TABLE_SIZE) // Wrapped around to the beginning of the table, element not found
            return;
    }
    if (table[index] == addr)
        table[index] = NULL; // Marking slot as empty by setting it to NULL
}

bool contains(void* addr)
{
    size_t index = hash(addr);
    while (table[index] != NULL && table[index] != addr)
    {
        ++index;
        if (index == TABLE_SIZE) // Wrapped around to the beginning of the table, element not found
            return false;
    }
    return (table[index] == addr);
}

int main() {
    // Example usage:
    int var = 10;
    add(&var);
    printf("%d\n", contains(&var)); // Should print: 1
    remove(&var);
    printf("%d\n", contains(&var)); // Should print: 0
    return 0;
}