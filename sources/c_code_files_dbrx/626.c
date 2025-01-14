#include <fcgiapp.h>
#include <stdio.h>

int main(void) {
    int count = 0;
    while (FCGI_Accept() >= 0 && count < 100) {
        printf("Hello, FastCGI World!\n");
        ++count;
    }
    return FCGI_EXIT_SUCCESS;
}