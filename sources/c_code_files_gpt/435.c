#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <openssl/ssl.h>
#include <openssl/err.h>

#define PORT 443
#define HOST "example.com"

int main() {
    // Initialize OpenSSL
    SSL_library_init();
    SSL_load_error_strings();
    ERR_load_BIO_strings();

    // Create a new SSL context
    SSL_CTX *ctx = SSL_CTX_new(TLS_client_method());
    if (!ctx) {
        printf("Failed to create SSL context\n");
        return 1;
    }

    // Create a new socket
    int socket_fd = socket(AF_INET, SOCK_STREAM, 0);
    if (socket_fd < 0) {
        printf("Failed to create socket\n");
        return 1;
    }

    // Set up the socket address
    struct sockaddr_in server_addr;
    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(PORT);
    inet_pton(AF_INET, HOST, &server_addr.sin_addr);

    // Connect to the server
    if (connect(socket_fd, (struct sockaddr *)&server_addr, sizeof(server_addr)) < 0) {
        printf("Failed to connect to server\n");
        return 1;
    }

    // Create a new SSL object
    SSL *ssl = SSL_new(ctx);
    if (!ssl) {
        printf("Failed to create SSL object\n");
        return 1;
    }

    // Set the socket file descriptor for the SSL object
    SSL_set_fd(ssl, socket_fd);

    // Perform the SSL/TLS handshake
    if (SSL_connect(ssl) <= 0) {
        printf("Failed to perform SSL/TLS handshake\n");
        return 1;
    }

    // Write data
    char *buf = "Hello, server!";
    int num_bytes = strlen(buf);
    if (SSL_write(ssl, buf, num_bytes) <= 0) {
        printf("Failed to write data\n");
        return 1;
    }

    // Read data
    char read_buf[1024];
    int bytes_read = SSL_read(ssl, read_buf, 1024);
    if (bytes_read <= 0) {
        printf("Failed to read data\n");
        return 1;
    }
    printf("Received: %s\n", read_buf);

    // Shutdown the SSL/TLS connection
    SSL_shutdown(ssl);

    // Clean up
    SSL_free(ssl);
    SSL_CTX_free(ctx);
    close(socket_fd);

    return 0;
}