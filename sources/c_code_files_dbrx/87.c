#include <stdlib.h>

int main() {
    int seqNum = 10; // Define seqNum
    char **sequence = (char **) malloc(sizeof(char *) * seqNum);
    // Don't forget to free the memory when you're done with it
    free(sequence);
    return 0;
}