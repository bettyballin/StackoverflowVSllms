#include <stdio.h>

void outputHeaders() {
    printf("Content-Type: text/html; charset=UTF-8\r\n");
    printf("Transfer-Encoding: chunked\r\n");
    printf("Content-Encoding: gzip\r\n"); // Indicate that the response body is compressed.
}

int main() {
    outputHeaders();
    return 0;
}