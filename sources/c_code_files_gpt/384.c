#include <stdio.h>
#include <string.h>

void hexToDecimalString(unsigned char hex[], int hex_len, char *decimalStr) {
    // Assuming the hex array is in big-endian format
    unsigned char decimal[20] = {0}; // Array to hold the decimal digits
    int i, j;

    for (i = 0; i < hex_len; ++i) {
        int carry = hex[i];
        for (j = 19; j >= 0; --j) {
            carry += decimal[j] * 256;
            decimal[j] = carry % 10;
            carry /= 10;
        }
    }

    // Convert the decimal array to a string
    int start = 0;
    while (start < 20 && decimal[start] == 0) {
        ++start;
    }

    for (i = start; i < 20; ++i) {
        decimalStr[i - start] = '0' + decimal[i];
    }
    decimalStr[20 - start] = '\0';
}

int main() {
    unsigned char hex[5] = {0xFF, 0xFF, 0xFF, 0xFF, 0xFF};
    char decimalStr[21]; // 20 digits + null terminator

    hexToDecimalString(hex, 5, decimalStr);

    printf("Decimal: %s\n", decimalStr);

    return 0;
}