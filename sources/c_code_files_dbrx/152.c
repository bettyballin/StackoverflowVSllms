#include <stdio.h>
#include <stdlib.h>

char *create_string(size_t size) {
  char *s = malloc((size + 1) * sizeof(char));
  if (!s) {
    // Handle error or signal insufficient memory.
    return NULL;
  }
  s[0] = '\0';
  return s;
}

int main() {
  size_t size = 10; // Example size
  char *str = create_string(size);
  if (str) {
    printf("Successfully allocated string of size %zu.\n", size);
    free(str); // Don't forget to free the allocated memory
  } else {
    printf("Failed to allocate memory.\n");
  }
  return 0;
}