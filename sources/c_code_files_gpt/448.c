#include <stdio.h>
#include <stdint.h>
#include <inttypes.h>

int main(void)
{
  int x;
  int *ptr = &x;

  printf("ptr = %p\n", (void *)ptr);
  printf("sizeof(ptr) = %zu\n", sizeof(ptr));

  int64_t i1 = (int64_t) ptr;
  printf("i1 = 0x%" PRIx64 "\n", i1);
  printf("sizeof(i1) = %zu\n", sizeof(i1));

  return 0;
}