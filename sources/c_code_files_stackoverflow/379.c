#include <stdio.h>
#include <string.h>

int main() {
    char s[100] = "";
    int i;

    strcat(s, "[");

    for (i = 0; i < 5; ++i) {
        if (i) strcat(s, ",");
        char temp[10];
        sprintf(temp, "\"%d\"", i);
        strcat(s, temp);
    }

    strcat(s, "]");

    printf("%s\n", s);

    return 0;
}