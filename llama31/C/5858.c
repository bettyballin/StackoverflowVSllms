#include <stdio.h>\n#include <stdint.h>\n\nuint32_t crc32(const char *data, size_t length) {\n    uint32_t crc = 0xFFFFFFFF;\n    for (size_t i = 0; i < length; i++) {\n        crc = (crc >> 8) ^ (crc & 0xFF) ^ (data[i] & 0xFF);\n    }\n    return ~crc;\n}