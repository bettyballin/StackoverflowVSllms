uint16_t add16(uint16_t a, uint16_t b)\n{\n  uint16_t c = a + b;\n  if (c < a)  /* Can only happen due to overflow */\n    c = -1;\n  return c;\n}