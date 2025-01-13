uint32_t generate_guid() {\n    static uint32_t x = 123456789, y = 362436069, z = 521288629, w = 88675123;\n    uint32_t t = x ^ (x << 11);\n    x = y; y = z; z = w;\n    w = (w ^ (w >> 19)) ^ (t ^ (t >> 8));\n    return w;\n}