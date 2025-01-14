#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int current;
    int end;
} Iterator;

void init_iterator(Iterator* it, int start, int end) {
    it->current = start;
    it->end = end;
}

int next(Iterator* it) {
    if (it->current < it->end) {
        return it->current++;
    } else {
        return -1; // Indicates the end of the iteration
    }
}

int main() {
    Iterator it;
    init_iterator(&it, 0, 10);

    int value;
    while ((value = next(&it)) != -1) {
        printf("%d\n", value); // Added newline character
    }

    return 0;
}