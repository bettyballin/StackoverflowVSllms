#include <random>\n\nstd::random_device rd;\nstd::mt19937 gen(rd());\nstd::uniform_int_distribution<uint32_t> dis(0, 0xFFFFFFFF);\nuint32_t guid = dis(gen);