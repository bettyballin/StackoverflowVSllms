#include <stdio.h>

// Function prototypes need types for all parameters in modern C
void bcopy(unsigned char *from, unsigned char *to, int count);

void bcopy(unsigned char *from, unsigned char *to, int count) {
    // For most systems, you would use a while loop like this
    while ((count--) > 0) {
        *to++ = *from++;
    }
    return;
}

// Example usage
int main() {
    unsigned char src[] = "Hello, World!";
    unsigned char dst[14];
    
    bcopy(src, dst, 14);
    
    printf("%s\n", dst);
    
    return 0;
}