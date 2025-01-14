#include <stdio.h>
#include <stdlib.h>

int main() {
    #pragma GCC diagnostic push
    #pragma GCC diagnostic ignored "-Wdeprecated-declarations"

    // Your code that uses mktemp
    char template[] = "fileXXXXXX";
    char *filename = mktemp(template);
    printf("Temporary file name: %s\n", filename);

    #pragma GCC diagnostic pop

    return 0;
}