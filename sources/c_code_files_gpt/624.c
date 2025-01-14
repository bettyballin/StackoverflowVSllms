#include "fcgi_stdio.h"
#include <stdlib.h>

int main(void) {
    while (FCGI_Accept() >= 0) {
        printf("Content-type: text/html\r\n"
               "\r\n"
               "<html><head><title>FastCGI Hello!</title></head>"
               "<body><h1>Hello, FastCGI!</h1></body></html>");
    }

    return 0;
}