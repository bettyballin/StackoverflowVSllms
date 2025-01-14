#include <stdlib.h>

int main() {
    int seqNum = 10; // Define seqNum before using it
    char **sequence = (char **)malloc(sizeof(char *) * seqNum);
    // Don't forget to free the allocated memory when you're done
    free(sequence);
    return 0;
}