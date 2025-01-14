#include <stdlib.h>

int main() {
    char **sequence;
    int seqNum = 10; // Initialize seqNum with a value

    // Assuming seqNum is initialized somewhere before this line
    sequence = (char **)malloc(sizeof(char *) * seqNum);

    // Don't forget to free the memory when you're done
    free(sequence);

    return 0;
}