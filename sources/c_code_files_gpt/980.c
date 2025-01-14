#include <stdio.h>

int foo(int x) {
  if (x)
    return -1;
  else
    return 0;
}

int main() {
  int exampleValue = 5; // Example value to demonstrate foo
  int result = foo(exampleValue);
  printf("The result of foo(%d) is %d\n", exampleValue, result);
  return 0;
}