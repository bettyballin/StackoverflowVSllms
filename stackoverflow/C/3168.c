unsigned myBitOperation(unsigned x)\n{\n    return ((x<<1) | (x>>1)) & (~x);\n}