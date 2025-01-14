#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(void) {
    char **sequence;
    int seqNum = 10;

    sequence = (char **) malloc(sizeof(char *) * seqNum);
    if (!sequence) {
        fprintf(stderr, "Couldn't allocate memory!\n");
        exit(EXIT_FAILURE);
    }

    // Don't forget to free the allocated memory when you're done
    free(sequence);

    return 0;
}