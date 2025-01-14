#include <stdint.h>

typedef unsigned char BYTE;
typedef unsigned long DWORD;

int main() {
    BYTE hash[20]; // SHA1 produces a 20-byte hash
    DWORD hashLen = 20;
    return 0;
}