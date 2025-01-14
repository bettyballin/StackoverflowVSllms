#include <stdio.h>

int main() {
    uint64_t u = 20090520145024798;
    unsigned long w = u % 1000000000;
    unsigned millisec = w % 1000;
    w /= 1000;
    unsigned sec = w % 100;
    w /= 100;
    unsigned min = w % 100;
    unsigned hour = w / 100;
    unsigned long v = u / 1000000000;
    unsigned day = v % 100;
    v /= 100;
    unsigned month = v % 100;
    unsigned year = v / 100;

    printf("Year: %u, Month: %u, Day: %u, Hour: %u, Minute: %u, Second: %u, Millisecond: %u\n", 
           year, month, day, hour, min, sec, millisec);

    return 0;
}