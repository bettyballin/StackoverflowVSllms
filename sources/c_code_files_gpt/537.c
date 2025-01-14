#include <stdio.h>

#ifdef _WIN32
// Windows-specific code
void platformSpecificFunction() {
    printf("Windows implementation\n");
}
#else
#include <unistd.h>
// Unix-specific code
void platformSpecificFunction() {
    printf("Unix implementation\n");
}
#endif

int main() {
    platformSpecificFunction();
    return 0;
}