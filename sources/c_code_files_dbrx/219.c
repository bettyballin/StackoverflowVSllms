#include <stdio.h>
#include <string.h>

int main() {
    const char* var = "var";
    char message[50] = "TEXT-";  // Make sure the buffer size is big enough.
    strcat(message, var);

    const char* foo = "foo", * bar = "bar";
    char message2[100];       // Same logic applies here.
    sprintf(message2, "%s %s TEXT %s", "TEXT ", foo, bar);

    return 0;
}