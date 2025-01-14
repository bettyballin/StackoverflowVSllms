#include <stdlib.h>

typedef struct Bar {
    // This isn't too important
} Bar;

#define EMPTY_LIST NULL

typedef struct BarList {
    Bar *val;
    struct BarList *nextBar;
} BarList;

void barPush(BarList **list, Bar *bar) {
    // If there is no move to add, then we are done
    if (bar == NULL) return;

    // Allocate space for the new node
    BarList *newNode = malloc(sizeof(BarList));

    // Assign the right values
    newNode->val = bar;
    newNode->nextBar = *list;

    // Set list to be equal to the new head of the list
    *list = newNode;
}

int main() {
    BarList *l;

    l = EMPTY_LIST;
    Bar b1, b2;

    barPush(&l, &b1); // Pass the address of l
    barPush(&l, &b2);

    // Continue with the rest of your code...

    return 0;
}