#include <stdlib.h>

typedef struct Bar {
    // Assuming some members are defined here...
    int dummy;  // Replace with actual members
} Bar;

typedef struct Bar * BarRef;

#define EMPTY_LIST NULL

typedef struct BarList {
    BarRef val;
    struct BarList *nextBar;
} *BarNode;
typedef struct BarList **BarListRef;

void barPush(BarListRef list, BarRef bar) {
    // Allocate space for the new node.
    BarNode newNode = malloc(sizeof(struct BarList));

    if (newNode == NULL) return;  // If allocation failed

    // Assign values to the new node.
    newNode->val = bar;
    newNode->nextBar = *list;

    // Set list to be equal to the new head of the list (updating original l).
    *list = newNode;
}