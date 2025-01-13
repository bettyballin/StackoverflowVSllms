#include <stdint.h>\n#include <string.h>\n\nvoid md5(const uint8_t *data, size_t len, uint8_t *hash) {\n    uint32_t h0 = 0x67452301;\n    uint32_t h1 = 0xefcdab89;\n    uint32_t h2 = 0x98badcfe;\n    uint32_t h3 = 0x10325476;\n\n    for (size_t i = 0; i < len; i += 64) {\n        uint32_t w[16];\n        for (size_t j = 0; j < 16; j++) {\n            w[j] = (data[i + j * 4] << 24) | (data[i + j * 4 + 1] << 16) | (data[i + j * 4 + 2] << 8) | data[i + j * 4 + 3];\n        }\n\n        uint32_t a = h0;\n        uint32_t b = h1;\n        uint32_t c = h2;\n        uint32_t d = h3;\n\n        for (size_t j = 0; j < 64; j++) {\n            uint32_t f, g;\n\n            if (j < 20) {\n                f = (b & c) | ((~b) & d);\n                g = j;\n            } else if (j < 40) {\n                f = (b ^ c ^ d);\n                g = (5 * j + 1) % 16;\n            } else if (j < 60) {\n                f = (b & c) | (b & d) | (c & d);\n                g = (3 * j + 5) % 16;\n            } else {\n                f = (b ^ c ^ d);\n                g = (7 * j) % 16;\n            }\n\n            uint32_t temp = d;\n            d = c;\n            c = b;\n            b += LEFTROTATE((a + f + w[g]), j);\n            a = temp;\n        }\n\n        h0 += a;\n        h1 += b;\n        h2 += c;\n        h3 += d;\n    }\n\n    hash[0] = (h0 >> 24) & 0xff;\n    hash[1] = (h0 >> 16) & 0xff;\n    hash[2] = (h0 >> 8) & 0xff;\n    hash[3] = h0 & 0xff;\n    hash[4] = (h1 >> 24) & 0xff;\n    hash[5] = (h1 >> 16) & 0xff;\n    hash[6] = (h1 >> 8) & 0xff;\n    hash[7] = h1 & 0xff;\n    hash[8] = (h2 >> 24) & 0xff;\n    hash[9] = (h2 >> 16) & 0xff;\n    hash[10] = (h2 >> 8) & 0xff;\n    hash[11] = h2 & 0xff;\n    hash[12] = (h3 >> 24) & 0xff;\n    hash[13] = (h3 >> 16) & 0xff;\n    hash[14] = (h3 >> 8) & 0xff;\n    hash[15] = h3 & 0xff;\n}\n\n#define LEFTROTATE(x, s) (((x) << (s)) | ((x) >> (32 - (s))))