#include <openssl/ssl.h>
#include <openssl/err.h>
#include <stdio.h>  // Include for perror and stderr
#include <stdlib.h> // Include for exit
#include <unistd.h> // Include for close

void initialize_openssl() {
    SSL_load_error_strings();
    OpenSSL_add_ssl_algorithms();
}

void cleanup_openssl() {
    EVP_cleanup();
}

SSL_CTX *create_context() {
    const SSL_METHOD *method;
    SSL_CTX *ctx;

    method = SSLv23_server_method();
    ctx = SSL_CTX_new(method);
    if (!ctx) {
        perror("Unable to create SSL context");
        ERR_print_errors_fp(stderr);
        exit(EXIT_FAILURE);
    }

    return ctx;
}

void configure_context(SSL_CTX *ctx) {
    SSL_CTX_set_ecdh_auto(ctx, 1);

    if (SSL_CTX_use_certificate_file(ctx, "server-cert.pem", SSL_FILETYPE_PEM) <= 0) {
        ERR_print_errors_fp(stderr);
        exit(EXIT_FAILURE);
    }

    if (SSL_CTX_use_PrivateKey_file(ctx, "server-key.pem", SSL_FILETYPE_PEM) <= 0 ) {
        ERR_print_errors_fp(stderr);
        exit(EXIT_FAILURE);
    }
}

int main(int argc, char **argv) {
    int sock, client_sock; // Declare client_sock
    SSL_CTX *ctx;

    initialize_openssl();
    ctx = create_context();

    configure_context(ctx);

    /* Set up the server socket and accept connections... */
    // NOTE: Actual socket setup and client connection acceptance code is omitted here.
    // For demonstration, assume client_sock is correctly set up.

    SSL *ssl;
    ssl = SSL_new(ctx);
    SSL_set_fd(ssl, client_sock);

    if (SSL_accept(ssl) <= 0) {
        ERR_print_errors_fp(stderr);
    } else {
        /* Do SSL read/write operations */
    }

    SSL_shutdown(ssl);
    SSL_free(ssl);

    close(client_sock);
    SSL_CTX_free(ctx);
    cleanup_openssl();
    return 0; // Return an integer to indicate successful execution
}