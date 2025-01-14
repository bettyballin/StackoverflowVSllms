#include <stdio.h>
#include <math.h>  // For isnan() function in case atof() returns a non-number value
#include <string.h> // For memcpy() function

int main(void) {  // Use proper prototype for main - void if no arguments are expected
    const char *yytext = "0";
    float f = (float)atof(yytext);
    size_t t;
    memcpy(&t, &f, sizeof(float)); // Use memcpy() to avoid breaking strict aliasing rules
    printf("t should be 0 but is %lu\n", t);  // size_t should be printed using %zu or %lu in older systems
    return 0;
}