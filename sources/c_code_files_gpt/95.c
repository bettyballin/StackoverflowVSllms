#include <stdio.h>
#include <time.h>

int main() {
    char ft[256];
    time_t t = time(NULL);
    struct tm *tmp = localtime(&t);

    if (tmp == NULL) {
        perror("localtime");
        return 1;
    }

    if (strftime(ft, sizeof(ft), "%D - %T", tmp) == 0) {
        fprintf(stderr, "strftime returned 0");
        return 1;
    }

    printf("Formatted time: %s\n", ft); // Added '\n' for better readability
    return 0;
}