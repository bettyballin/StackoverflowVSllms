#include <stdio.h>
#include <stdlib.h>
#include <openssl/ssl.h>
#include <openssl/err.h>

int main() {
    // Initialize OpenSSL
    SSL_library_init();
    SSL_load_error_strings();

    // Create an SSL context
    SSL_CTX *ctx = SSL_CTX_new(TLS_client_method());
    if (ctx == NULL) {
        ERR_print_errors_fp(stderr);
        abort();
    }

    // Set the file and directory where trusted CAs are located
    if (SSL_CTX_load_verify_locations(ctx, "cacert.pem", "/path/to/cadir") <= 0) {
        ERR_print_errors_fp(stderr);
        abort();
    }

    // Clean up
    SSL_CTX_free(ctx);

    return 0;
}