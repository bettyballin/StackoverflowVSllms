#include <stdlib.h>\n\ntypedef struct Bar {\n    // This isn't too important\n} Bar;\n\n#define EMPTY_LIST NULL\n\ntypedef struct BarList {\n    Bar *val;\n    struct BarList *nextBar;\n} BarList;\n\nvoid barPush(BarList **list, Bar *bar) {\n    // If there is no move to add, then we are done\n    if (bar == NULL) return;\n\n    // Allocate space for the new node\n    BarList *newNode = malloc(sizeof(BarList));\n\n    // Assign the right values\n    newNode->val = bar;\n    newNode->nextBar = *list;\n\n    // Set list to be equal to the new head of the list\n    *list = newNode;\n}\n\nint main() {\n    BarList *l;\n\n    l = EMPTY_LIST;\n    Bar b1, b2;\n\n    barPush(&l, &b1); // Pass the address of l\n    barPush(&l, &b2);\n\n    // Continue with the rest of your code...\n\n    return 0;\n}