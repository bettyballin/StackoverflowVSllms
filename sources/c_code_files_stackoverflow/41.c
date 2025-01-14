#include <stdio.h>
#include <direct.h>

int main() {
    char* whereAmI = _getcwd(NULL, 0);
    printf("%s\n", whereAmI);
    free(whereAmI);
    return 0;
}