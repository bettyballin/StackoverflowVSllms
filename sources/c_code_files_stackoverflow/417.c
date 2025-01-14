#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    FILE *stream = stdin; // or any other file stream
    char line[1024];
    int length = 1024;
    char keptline[1024];
    int count = 0;

    while (fgets(line, length, stream) != NULL) {
        count++;
        if ((rand() * count) / RAND_MAX == 0)
            strcpy(keptline, line);
    }

    // print the kept line
    printf("%s", keptline);

    return 0;
}