#include <stdlib.h>
#include <string.h>

int main() {
    char hex_str[16] = "0xefffffff"; // your string here, in this case 0xefffffff
    long hex_num;
    hex_num = strtol(hex_str, NULL, 16);
    return 0;
}