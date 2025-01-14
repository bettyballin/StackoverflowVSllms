#include <stdio.h>
#include <stdint.h>
#include <byteswap.h>

int main() {
  uint64_t rax = 0x0123456789abcdef;
  rax = bswap_64(rax);
  printf("%llx\n", rax); // should output 0x01234567efcdab89
  return 0;
}