double offset = pow(2, (i >> 20) - 0x3ff) * (((i & 0xfffff) + 0x100000) / (double) 0x100000);