#include <openssl/ssl.h>
#include <openssl/bio.h>
#include <stdio.h>

void error(const char *message) {
    printf("Error: %s\n", message);
}

int connect(SSL *ssl, int socket) {
    if (BIO_set_fd(SSL_get_rbio(ssl), socket, BIO_CLOSE) <= 0 ||
        BIO_set_fd(SSL_get_wbio(ssl), socket, BIO_CLOSE) <= 0) {
            error("failed to set BIO");
    }
    return 0; // Return a value to avoid warning
}