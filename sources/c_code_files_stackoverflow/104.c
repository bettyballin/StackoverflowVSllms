#include <stdio.h>
#include <string.h>

// Simple hash function
unsigned int hash(char *value) {
    unsigned int hash = 0;
    for (int i = 0; i < strlen(value); i++) {
        hash += value[i];
    }
    return hash;
}

typedef struct _tuple {
    unsigned int bitvalues;
    void *data;
} tuple;

int main() {
    tuple a, b, c, d;
    a.bitvalues = hash("one");
    a.bitvalues |= hash("four");
    // a.data = something;

    unsigned int event = 0;
    char *string_val = "one";
    event |= hash(string_val);

    tuple *tuples[] = {&a, &b, &c, &d};
    unsigned int test = event;

    for (int i = 0; i < 4; i++) {
        tuple *x = tuples[i];
        if (x->bitvalues & test == test) {
            printf("Tuple %d matches\n", i + 1);
        }
    }

    return 0;
}