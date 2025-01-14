#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <openssl/ssl.h>
#include <openssl/err.h>

#define HOSTNAME "127.0.0.1"
#define PORT 4433

// Structure to hold SSL and socket information
typedef struct {
    SSL *ssl;
    int sockfd;
} ssl_socket_t;

// Function to create a new socket and connect to a server
int create_socket(const char *hostname, int port) {
    int sockfd = socket(PF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) {
        perror("socket creation failed");
        exit(EXIT_FAILURE);
    }

    struct sockaddr_in server_addr;
    server_addr.sin_family = AF_INET;
    inet_pton(AF_INET, hostname, &(server_addr.sin_addr));
    server_addr.sin_port = htons(port);

    if (connect(sockfd, (struct sockaddr *)&server_addr, sizeof(server_addr)) < 0) {
        perror("connect failed");
        exit(EXIT_FAILURE);
    }
    return sockfd;
}

// Function to initiate an SSL connection
void open_connection(const char *hostname, int port) {
    // Initialize OpenSSL
    SSL_library_init();
    SSL_load_error_strings();

    // Create an SSL context
    const SSL_METHOD *method = TLS_client_method(); /* Using TLS method for broader compatibility */
    SSL_CTX *ctx = SSL_CTX_new(method);
    if (!ctx) {
        ERR_print_errors_fp(stderr);
        exit(EXIT_FAILURE);
    }

    // Create an SSL structure for the connection
    ssl_socket_t ss;
    ss.ssl = SSL_new(ctx);
    if (!ss.ssl) {
        ERR_print_errors_fp(stderr);
        SSL_CTX_free(ctx);
        exit(EXIT_FAILURE);
    }

    // Create a socket and connect to the server
    ss.sockfd = create_socket(hostname, port);

    // Attach the socket to the SSL
    SSL_set_fd(ss.ssl, ss.sockfd);

    // Perform the SSL/TLS handshake
    int err = SSL_connect(ss.ssl);
    if (err <= 0) {
        ERR_print_errors_fp(stderr);
        SSL_free(ss.ssl);
        SSL_CTX_free(ctx);
        close(ss.sockfd);
        exit(EXIT_FAILURE);
    }

    // Example: Send a message over the SSL connection
    char *msg = "Hello, server!";
    err = SSL_write(ss.ssl, msg, strlen(msg));
    if (err <= 0) {
        ERR_print_errors_fp(stderr);
    }

    // Clean up
    SSL_free(ss.ssl);
    SSL_CTX_free(ctx);
    close(ss.sockfd);
}

int main() {
    open_connection(HOSTNAME, PORT);
    return 0;
}