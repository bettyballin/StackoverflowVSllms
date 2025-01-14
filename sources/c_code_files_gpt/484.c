#include <stdio.h>
#include <stdlib.h>

typedef struct Continuation {
    void (*func)(struct Continuation *cont, void *arg);
    void *arg;
    struct Continuation *next;
} Continuation;

void trampoline(Continuation *cont) {
    while (cont != NULL) {
        Continuation *next = cont->next;
        cont->func(cont, cont->arg);
        cont = next;
    }
}

// Example function to be called by the trampoline
void example_func(Continuation *cont, void *arg) {
    int *val = (int *)arg;
    printf("Value: %d\n", *val);  // Fixed the newline character here

    // Here you would set up the next continuation if needed
    // For example, to chain another call:
    // cont->next = create_next_continuation(...);
}

int main() {
    int value = 42;

    Continuation *cont = malloc(sizeof(Continuation));
    cont->func = example_func;
    cont->arg = &value;
    cont->next = NULL;

    trampoline(cont);

    free(cont);
    return 0;
}