#include <stdio.h>
#include <stdlib.h>

// Define the structure for a Bar
typedef struct Bar {
    int value;
} Bar;

// Define the structure for a BarList
typedef struct BarList {
    Bar *bars;
    int size;
    int capacity;
} BarList;

// Define the type for a BarList reference
typedef BarList* BarListRef;

// Function to create a new BarList
BarListRef createBarList(int initialCapacity) {
    BarListRef list = malloc(sizeof(BarList));
    list->bars = malloc(initialCapacity * sizeof(Bar));
    list->size = 0;
    list->capacity = initialCapacity;
    return list;
}

// The provided function
void barPush(BarListRef list, Bar *bar) {
    if (list->size >= list->capacity) {
        list->capacity *= 2;
        list->bars = realloc(list->bars, list->capacity * sizeof(Bar));
    }
    list->bars[list->size] = *bar;
    list->size++;
}

int main() {
    // Create a new BarList
    BarListRef list = createBarList(2);

    // Create a new Bar
    Bar bar;
    bar.value = 10;

    // Push the Bar onto the list
    barPush(list, &bar);

    // Print the value of the Bar in the list
    printf("Value of Bar in list: %d\n", list->bars[0].value);

    // Clean up
    free(list->bars);
    free(list);

    return 0;
}