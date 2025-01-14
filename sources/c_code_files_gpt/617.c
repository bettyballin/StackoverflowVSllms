#include <stdio.h>
#include <stdlib.h>

int main(void) {
    // Required for CGI scripts
    printf("Content-Type: application/json\n");

    // JSON response
    printf("{\"message\": \"Hello from C CGI!\"}\n");

    return 0;
}