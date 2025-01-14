#include <stdio.h>
#include <string.h>

void format_float(char *buf, size_t buf_size, float value) {
    if (value == (int)value) {
        snprintf(buf, buf_size, "%d", (int)value);
    } else {
        snprintf(buf, buf_size, "%.6f", value);
        // Remove trailing zeros
        for (int i = strlen(buf) - 1; i > 0 && buf[i] == '0'; i--) {
            buf[i] = '\0';
        }
        // Remove trailing decimal point if there are no fractional digits
        if (buf[strlen(buf) - 1] == '.') {
            buf[strlen(buf) - 1] = '\0';
        }
    }
}

int main() {
    char out[50];
    float myFloat = 15.6f;
    float myInt = 5.0f;
    float myLarge = 7000000.0f;

    format_float(out, sizeof(out), myFloat);
    printf("my float is %s\n", out);

    format_float(out, sizeof(out), myInt);
    printf("my int is %s\n", out);

    format_float(out, sizeof(out), myLarge);
    printf("my large is %s\n", out);

    // Example with mixed format string
    int myIntVal = 10;
    sprintf(out, "%d ", myIntVal);
    size_t len = strlen(out);
    format_float(out + len, sizeof(out) - len, myFloat);
    printf("mixed format: %s\n", out);

    return 0;
}