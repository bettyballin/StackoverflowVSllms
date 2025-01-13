#include <stdint.h>\n#include <string.h>\n\nvoid rgb_to_argb(const uint8_t* rgb, uint8_t* argb, size_t num_pixels) {\n    for (size_t i = 0; i < num_pixels; ++i) {\n        // Manually setting alpha to 255 and copying RGB values\n        argb[i * 4 + 3] = 255;\n        memcpy(&argb[i * 4], &rgb[i * 3], 3);\n    }\n}