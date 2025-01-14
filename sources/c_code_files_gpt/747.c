#include <stdarg.h>
#include <stdio.h>

void MyPrintf(char const* format, va_list args) __attribute__((format(printf, 1, 0)));

void MyPrintf(char const* format, va_list args) {
    vprintf(format, args);
}

int main() {
    int i = 10;
    char c = 'A';
    char str[] = "Hello, World!";
    va_list args;
    va_start(args, str);
    va_arg(args, int) = i;
    va_arg(args, char) = c;
    va_arg(args, char*) = str;
    MyPrintf("%d %c %s\n", args);
    va_end(args);
    return 0;
}