#include <stdio.h>
#include <string.h>

int main(void) {
  char c[10] = "1";
  char d[] = "1";

  // Option with strcat()
  strcat(c, d);
  printf("Option with strcat(): %s\n", c);

  // Manual concatenation
  int len_a = strlen(c) + strlen(d) + 1;
  char a[len_a];
  for (int i = 0; i < strlen(c); ++i) {
    a[i] = c[i];
  }
  for (int j = 0; j < strlen(d); ++j) {
    a[strlen(c) + j] = d[j];
  }
  a[len_a - 1] = '\0';
  printf("Option manual way: %s\n", a);

  return 0;
}