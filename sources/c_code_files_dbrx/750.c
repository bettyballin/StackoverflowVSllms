#include <stdio.h>

int main() {
    char *tag = "your_tag";
    int data = 123;
    fprintf(stdout, "%-40.39s[%d]", tag, data); /* 39 is (width - 1) */
    return 0;
}