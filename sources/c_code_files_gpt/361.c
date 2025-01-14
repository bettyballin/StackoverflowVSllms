// mytime.c
#include <time.h>

// To avoid conflict with the standard library function, we rename our function
time_t my_time(time_t *t) {
    time_t fixed_time = 1609459200; // Fixed timestamp (e.g., Jan 1, 2021)
    if (t) {
        *t = fixed_time;
    }
    return fixed_time;
}

int main() {
    time_t t;
    my_time(&t);
    return 0;
}