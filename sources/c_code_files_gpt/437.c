#include <stdio.h>
#include <stdlib.h>
#include <openssl/bio.h>
#include <openssl/ssl.h>
#include <openssl/err.h>

int main() {
    // Initialize OpenSSL
    SSL_library_init();
    ERR_load_BIO_strings();
    OpenSSL_add_all_algorithms();

    // Assuming 'ctx' is an SSL context
    SSL_CTX *ctx = SSL_CTX_new(TLS_client_method());
    if (!ctx) {
        ERR_print_errors_fp(stderr);
        exit(EXIT_FAILURE);
    }

    BIO *bio = BIO_new_ssl_connect(ctx);
    if (!bio) {
        ERR_print_errors_fp(stderr);
        SSL_CTX_free(ctx);
        exit(EXIT_FAILURE);
    }

    BIO_set_conn_hostname(bio, "hostname:port");
    if (BIO_do_connect(bio) <= 0) {
        ERR_print_errors_fp(stderr);
        BIO_free_all(bio);
        SSL_CTX_free(ctx);
        exit(EXIT_FAILURE);
    }

    char *buf = "Hello, server!";
    int num_bytes = strlen(buf);
    if (BIO_write(bio, buf, num_bytes) <= 0) {
        ERR_print_errors_fp(stderr);
        BIO_free_all(bio);
        SSL_CTX_free(ctx);
        exit(EXIT_FAILURE);
    }

    char readbuf[1024];
    num_bytes = BIO_read(bio, readbuf, 1024);
    if (num_bytes <= 0) {
        ERR_print_errors_fp(stderr);
        BIO_free_all(bio);
        SSL_CTX_free(ctx);
        exit(EXIT_FAILURE);
    }
    readbuf[num_bytes] = '\0'; // Ensure null-termination
    printf("Received: %s\n", readbuf);

    BIO_free_all(bio);
    SSL_CTX_free(ctx);

    return 0;
}