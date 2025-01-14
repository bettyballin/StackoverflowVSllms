#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int lookup(char *word, char*array[]) {
  register int i;
  // size of Array for loop and bsearch use
  size_t n = sizeof(array)/sizeof(array[0]) - 1 /* Exclude NULL */;
  qsort (array, n, sizeof(char*), (int(*)(const void*, const void*)) strcmp);        /* Sort using in-built function*/
  char **p = (char**) bsearch(&word, array, n, sizeof(char *), (int(*)(const void*, const void*)) strcmp);

  return p != NULL ? (int) (p - array): -1;
}

int main() {
    char* array[] = {"apple", "banana", "cherry", NULL};
    char* word = "banana";
    printf("%d\n", lookup(word, array));
    return 0;
}