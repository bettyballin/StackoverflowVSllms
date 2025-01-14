#include <stdio.h>

typedef unsigned int Color;

int main() {
    Color colors[5] = {0xAARRGGBB, 0xAARRGGBB, 0xAARRGGBB, 0xAARRGGBB, 0xAARRGGBB};

    unsigned long sum1 = 0, sum2 = 0;
    for (int i = 0; i < 5; i++) {
        sum1 += colors[i] & 0x00FF00FF; // 0x00RR00BB
        sum2 += (colors[i] >> 8) & 0x00FF00FF; // 0x00AA00GG
    }
    unsigned long output = 0;
    output |= (((sum1 & 0xFFFF) / 5) & 0xFF);
    output |= (((sum2 & 0xFFFF) / 5) & 0xFF) << 8;
    sum1 >>= 16; sum2 >>= 16; // and now the top halves
    output |= (((sum1 & 0xFFFF) / 5) & 0xFF) << 16;
    output |= (((sum2 & 0xFFFF) / 5) & 0xFF) << 24;

    printf("%lx\n", output);

    return 0;
}