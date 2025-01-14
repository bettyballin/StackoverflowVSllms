#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// Comparison function for bsearch
int compare(const void *a, const void *b) {
    return strcmp(*(const char **)a, *(const char **)b);
}

// Function to lookup a word in a sorted array of strings
int lookup(char *word, char *array[], size_t size) {
    char **item = (char **)bsearch(&word, array, size, sizeof(char *), compare);

    if (item != NULL) {
        return item - array;
    }

    return -1;
}

int main() {
    // Example array of strings
    char *words[] = {"apple", "banana", "cherry", "date", "elderberry"};
    size_t numWords = sizeof(words) / sizeof(words[0]);
    
    // Ensure the array is sorted for bsearch to work correctly
    qsort(words, numWords, sizeof(char *), compare);

    // Example word to lookup
    char *targetWord = "cherry";

    int index = lookup(targetWord, words, numWords);

    if (index != -1) {
        printf("Found '%s' at index %d.\n", targetWord, index);
    } else {
        printf("Could not find '%s' in the list.\n", targetWord);
    }

    return 0;
}