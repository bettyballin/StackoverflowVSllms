#include <stdio.h>
#include <string.h>

void RemoveTrailingZeros(char *str) {
    char *ptr = strchr(str, '.');
    if (ptr != NULL) {
        while (*ptr == '0') {
            *ptr = '\0';
            ptr--;
        }
        if (*ptr == '.') {
            *ptr = '\0';
        }
    }
}

int main() {
    float myFloat = 15.6f;
    float myInt = 5.0f;
    float myLarge = 7000000.0f;
    char out[256];

    sprintf(out, "my float is %g", myFloat);
    RemoveTrailingZeros(out);
    printf("%s\n", out); // prints: my float is 15.6

    sprintf(out, "my int is %.0f", myInt);
    RemoveTrailingZeros(out);
    printf("%s\n", out); // prints: my int is 5

    sprintf(out, "my large is %.0f", myLarge);
    RemoveTrailingZeros(out);
    printf("%s\n", out); // prints: my large is 7000000

    return 0;
}