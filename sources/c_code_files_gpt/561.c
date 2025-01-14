#include <stdio.h>

// Simplified example of a Spectre attack in C
unsigned char array1[256];
unsigned char array2[256 * 4096];
char secret = 'S';
size_t array1_size = 256;

void victim_function(size_t x) {
    unsigned char temp = 0;
    if (x < array1_size) {
        temp &= array2[array1[x] * 4096];
    }
}

int main() {
    size_t x = 0;
    victim_function(x);
    return 0;
}