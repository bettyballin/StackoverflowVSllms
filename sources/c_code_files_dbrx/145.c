#include <stdio.h>

// Static function definition
static void myStaticFunction(void) {
  printf("Inside myStaticFunction\n");
  // Function body here...
}

int main() {
  // Accessible and callable within this translation unit.
  myStaticFunction();
  return 0;
}