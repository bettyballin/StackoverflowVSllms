#include <stdio.h>

char *getp() {
  static char s[10];
  // ...
  return s;
}

int main() {
  char *p = getp();
  printf("%s\n", p);
  return 0;
}