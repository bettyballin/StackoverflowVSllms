#include <stdio.h>
#include <openssl/bio.h>
#include <openssl/ssl.h>

// Function to handle errors
void error(const char *msg) {
    printf("Error: %s\n", msg);
    exit(1);
}

int bio_sock(SSL *ssl) {
    // Create dummy buffer for socket BIO context
    BIO *bio;
    int sock = SSL_get_fd(ssl);
    if (NULL == (bio = BIO_new_socket(sock, BIO_CLOSE))) {
        error("failed to create BIO");
    }
    return (int)bio; // Cast to int, but note that this might not be what you want
}

int main() {
    // Initialize OpenSSL
    SSL_library_init();
    SSL_load_error_strings();

    // Create a new SSL context
    SSL_CTX *ctx = SSL_CTX_new(TLS_client_method());
    if (ctx == NULL) {
        error("failed to create SSL context");
    }

    // Create a new SSL object
    SSL *ssl = SSL_new(ctx);
    if (ssl == NULL) {
        error("failed to create SSL object");
    }

    // Call the bio_sock function
    int bio = bio_sock(ssl);

    // Clean up
    SSL_free(ssl);
    SSL_CTX_free(ctx);

    return 0;
}