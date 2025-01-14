#include <stdio.h>

#define SVN_REV "123" // Actual SVN Rev number fetched by SubWCRev
#define BUILD_DATE "20201231xxxxxxx" // Build date replaced automatically using a timestamp

int main() {
    printf("SVN Revision: %s\n", SVN_REV);
    printf("Build Date: %s\n", BUILD_DATE);
    return 0;
}