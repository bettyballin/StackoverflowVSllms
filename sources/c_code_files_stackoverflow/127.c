#include <stdio.h>

static int addTwo(int x)
{
  return x + 2;
}

int main()
{
  printf("%d\n", addTwo(5));  // Example usage
  return 0;
}