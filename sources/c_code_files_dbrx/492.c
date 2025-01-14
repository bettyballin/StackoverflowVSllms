#include <stdio.h>

int main() {
    printf("%4d %5.2f\n", 3, -1);  // Right adjusted   : "   3 -1.00"
    printf("%-4d %-+8.2e\n", 6, 7);  // Left/Right: "6     +7.00E+00"
    return 0;
}