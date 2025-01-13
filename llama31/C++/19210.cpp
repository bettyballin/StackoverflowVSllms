#include <cstdint>\n\nclass XorshiftRNG {\npublic:\n    XorshiftRNG(uint32_t seed) : state(seed) {}\n\n    uint32_t next() {\n        state ^= (state << 13) & 0xFFFFFFFF;\n        state ^= (state >> 17) & 0xFFFFFFFF;\n        state ^= (state << 5) & 0xFFFFFFFF;\n        return state;\n    }\n\nprivate:\n    uint32_t state;\n};