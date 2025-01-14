#include <stdio.h>
#include <stdlib.h>

// Define the structure for Bar
typedef struct Bar {
    // Example: Assume Bar has an integer id for demonstration
    int id;
} Bar;

// Define the structure for BarList
typedef struct BarList {
    Bar* val;
    struct BarList* nextBar;
} BarList;

void barPush(BarList** list, Bar* bar) {
    if (list == NULL) return; // need to pass in the pointer to your pointer to your list.

    // if there is no move to add, then we are done
    if (bar == NULL) return;

    // allocate space for the new node
    BarList* newNode = malloc(sizeof(BarList));

    // assign the right values
    newNode->val = bar;
    newNode->nextBar = *list;

    // and set the contents of the pointer to the pointer to the head of the list 
    // (ie: the pointer the the head of the list) to the new node.
    *list = newNode; 
}

int main() {
    BarList* list = NULL;

    // Create some example Bar instances
    Bar* bar1 = malloc(sizeof(Bar));
    bar1->id = 1;

    Bar* bar2 = malloc(sizeof(Bar));
    bar2->id = 2;

    // Push bars onto the list
    barPush(&list, bar1);
    barPush(&list, bar2);

    // Demonstrate that bars were added
    BarList* current = list;
    while (current != NULL) {
        printf("Bar ID: %d\n", current->val->id);
        current = current->nextBar;
    }

    // Don't forget to free allocated memory
    current = list;
    while (current != NULL) {
        BarList* next = current->nextBar;
        free(current->val); // Free the Bar instance
        free(current);      // Free the BarList node
        current = next;
    }

    return 0;
}