#pragma GCC diagnostic push
#pragma GCC diagnostic ignored "-Wdeprecated-declarations"
#include <stdio.h>
#pragma GCC diagnostic pop

int main() {
    char buffer[100];
    // Using gets() despite the warning
    gets(buffer);
    printf("%s\n", buffer);
    return 0;
}