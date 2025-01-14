#include <stdlib.h>

double strtoD(const char* restrict np, char** restrict ep) {
    return strtod(np, ep);
}