#include <stdio.h>

typedef struct {
    int len;
    char str[];
} somestring;

int main() {
    // example usage:
    int len = 10;
    somestring *s = malloc(sizeof(somestring) + len * sizeof(char));
    s->len = len;
    strcpy(s->str, "Hello");
    printf("%s\n", s->str);
    free(s);
    return 0;
}