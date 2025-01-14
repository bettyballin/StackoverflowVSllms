#include <stdio.h>
#include <stdlib.h>

int main() {
    const char *yytext = "0";
    const float f = (float)atof(yytext);
    int t = (int)f;

    printf("t should be 0 but is %d\n", t);
    return 0;
}