public bool IsBitTrue(int number, int bitPosition) {\n    return ((number & (1 << (bitPosition - 1))) != 0);\n}