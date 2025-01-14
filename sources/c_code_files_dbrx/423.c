#include <stdio.h>

void send(char *str) {
    printf("%s", str);
}

int main() {
    // Sending '1' using its decimal ASCII value
    char one_dec = 49;
    printf("Sending '1' using decimal ASCII: ");
    send(&one_dec);
    printf("\n");

    // Sending '1' using its hexadecimal ASCII value
    char one_hex[] = "\x31";
    printf("Sending '1' using hexadecimal ASCII: ");
    send(one_hex);
    printf("\n");

    return 0;
}