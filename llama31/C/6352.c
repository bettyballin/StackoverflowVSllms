ulong gf2step(ulong x, ulong p) {\n    x = x << 1; // "multiply" by x\n    if (x >= (1 << bits)) x = x ^ p;\n    return x;\n}