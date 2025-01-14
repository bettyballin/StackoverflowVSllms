#include <stdio.h>
#include <execinfo.h>
#include <stdlib.h>

void my_function(void) {
    void *array[10];
    size_t size;
    char **strings;
    size_t i;

    size = backtrace (array, 10);
    strings = backtrace_symbols (array, size);

    printf ("Obtained %zd stack frames.\n", size);

    for (i = 0; i < size; i++)
        printf ("%s\n", strings[i]);

    free (strings);
}

int main(void) {
    my_function ();
    return 0;
}