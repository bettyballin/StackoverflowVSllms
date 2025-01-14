#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    const char *var = "example";
    const char *foo = "foo";
    const char *bar = "bar";

    // Concatenate "TEXT " and var
    char *message = malloc(strlen("TEXT ") + strlen(var) + 1);
    if (message == NULL) {
        perror("Unable to allocate memory");
        return 1;
    }
    strcpy(message, "TEXT ");
    strcat(message, var);

    printf("%s\n", message);

    // Concatenate "TEXT ", foo, " TEXT ", and bar
    char *message2 = malloc(strlen("TEXT ") + strlen(foo) + strlen(" TEXT ") + strlen(bar) + 1);
    if (message2 == NULL) {
        perror("Unable to allocate memory");
        free(message);
        return 1;
    }
    strcpy(message2, "TEXT ");
    strcat(message2, foo);
    strcat(message2, " TEXT ");
    strcat(message2, bar);

    printf("%s\n", message2);

    // Free allocated memory
    free(message);
    free(message2);

    return 0;
}