#include <stdio.h>
#include <string.h>

struct Functor {
  bool operator()( char * a, char * b ) {
    return strcmp(a,b) < 0;
  }
};

int main() {
  // Example usage:
  Functor functor;
  char a[] = "apple";
  char b[] = "banana";
  printf("%d\n", functor(a, b));  // Output: 1 (true)
  return 0;
}