#include <openssl/ssl.h>
#include <openssl/err.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    SSL_CTX *ctx;
    SSL *ssl;
    int server = -1; // Initialize with an invalid value

    // Initialize OpenSSL
    SSL_library_init();
    SSL_load_error_strings();
    OpenSSL_add_all_algorithms();

    // Create a new SSL context
    ctx = SSL_CTX_new(TLS_client_method());
    if (ctx == NULL) {
        ERR_print_errors_fp(stderr);
        exit(EXIT_FAILURE);
    }

    // Load trusted CA certificates
    if (!SSL_CTX_load_verify_locations(ctx, "path/to/ca-certificates.crt", NULL)) {
        ERR_print_errors_fp(stderr);
        SSL_CTX_free(ctx);
        exit(EXIT_FAILURE);
    }

    // Create a new SSL connection
    ssl = SSL_new(ctx);
    if (ssl == NULL) {
        ERR_print_errors_fp(stderr);
        SSL_CTX_free(ctx);
        exit(EXIT_FAILURE);
    }

    // Connect to the server
    // (Assume 'server' is a valid socket connected to the server)
    // For demonstration purposes, we'll create a dummy socket
    server = socket(AF_INET, SOCK_STREAM, 0);
    if (server < 0) {
        perror("socket creation failed");
        SSL_free(ssl);
        SSL_CTX_free(ctx);
        exit(EXIT_FAILURE);
    }

    // Connect to a dummy server (replace with your actual server IP and port)
    struct sockaddr_in server_addr;
    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(443); // Replace with your server's port
    inet_pton(AF_INET, "127.0.0.1", &server_addr.sin_addr); // Replace with your server's IP
    if (connect(server, (struct sockaddr *)&server_addr, sizeof(server_addr)) < 0) {
        perror("connect failed");
        close(server);
        SSL_free(ssl);
        SSL_CTX_free(ctx);
        exit(EXIT_FAILURE);
    }

    SSL_set_fd(ssl, server);

    if (SSL_connect(ssl) <= 0) {
        ERR_print_errors_fp(stderr);
        SSL_free(ssl);
        SSL_CTX_free(ctx);
        close(server);
        exit(EXIT_FAILURE);
    }

    // Verify the server's certificate
    if (SSL_get_verify_result(ssl) != X509_V_OK) {
        fprintf(stderr, "Certificate verification failed\n");
        SSL_free(ssl);
        SSL_CTX_free(ctx);
        close(server);
        exit(EXIT_FAILURE);
    }

    // Proceed with secured communication
    // ...

    // Clean up
    SSL_free(ssl);
    SSL_CTX_free(ctx);
    EVP_cleanup();
    close(server);
    return 0;
}