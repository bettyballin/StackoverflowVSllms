#include <stdio.h>

short f(short x) { 
    return x; 
}

int main() { 
    long x = 0x10000007; 
    printf("%d\n", f((short)x)); 
    return 0; 
}