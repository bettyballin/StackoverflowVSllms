#include <stdio.h>
#include <string.h>

int strpos(char* a, char* b) {
  int n1, n2, i, j;
  n1 = strlen(a);
  n2 = strlen(b);
  for (i = 0; i <= n1-n2; i++) {
    for (j = 0; j < n2; j++) {
      if (a[i+j] != b[j]) break;
      else if (j+1 == n2) return i;
    }
  }
  return -1;
}

int main() {
  char* str1 = "Hello, World!";
  char* str2 = "World";
  int pos = strpos(str1, str2);
  if (pos != -1) {
    printf("Substring found at position %d\n", pos);
  } else {
    printf("Substring not found\n");
  }
  return 0;
}