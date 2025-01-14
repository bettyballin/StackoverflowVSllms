#include <stdio.h>

int main() {
    FILE* stderr_redirect = freopen( "C:/stderr.log", "w", stderr );

    // Code that writes to stderr
    fprintf(stderr, "This is an error message.\n");

    fclose( stderr_redirect );
    return 0;
}