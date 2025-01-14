#include <stdint.h>

uint16_t add16(uint16_t a, uint16_t b)
{
  uint16_t c = a + b;
  if (c < a)  /* Can only happen due to overflow */
    c = -1;
  return c;
}

int main() {
    // Test the function
    uint16_t result = add16(65530, 10);
    return 0;
}