#include <stdio.h>
#include <string.h>

int main() {
    char *tag = "Example Tag";
    int data = 123;

    fprintf(stdout, "%.*s%-*s[%d]\n",
            (int)strlen(tag), tag,
            (int)(40 - strlen(tag)), "----------------------------------------", data);

    return 0;
}