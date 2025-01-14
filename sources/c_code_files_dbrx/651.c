#include <stdio.h>
#include <errno.h>
#include <string.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <openssl/ssl.h>
#include <openssl/err.h>

/* Replace these with the actual values per your server */
const char *hostname = "example.com";
const int port_num = 443;

int main() {
    struct hostent *host;
    SSL_CTX *ctx;
    const SSL_METHOD *method;
    int verify_result, socket_fd;
    BIO *web_bio;
    char buffer[1024];

    /* Initialize OpenSSL library and check for errors */
    ERR_load_BIO_strings();
    SSL_load_error_strings();
    OPENSSL_config(NULL);

    /* Check if the required ciphers are loaded */
    if (OpenSSL_add_all_algorithms() != 1) {
        fprintf(stderr, "Error: failed to load all supported algorithms\n");
        return -1;
    }

    /* Get host information */
    host = gethostbyname(hostname);
    if (host == NULL) {
        perror("Unable to resolve server's IP address");
        return -1;
    }

    /* Create a new SSL context with TLS v 1.2 method */
    method = TLSv1_2_method();
    ctx = SSL_CTX_new(method);
    if (ctx == NULL) {
        fprintf(stderr, "Error: creating new SSL/TLS context\n");
        return -1;
    }

    /* Set up the connection */
    socket_fd = socket(AF_INET, SOCK_STREAM, 0);
    if (socket_fd < 0) {
        perror("Error creating socket!");
        return -1;
    }

    struct sockaddr_in reuse_addr_in;
    memset(&reuse_addr_in, '\0', sizeof(reuse_addr_in));
    reuse_addr_in.sin_family = AF_INET;
    reuse_addr_in.sin_port = htons(port_num);
    memcpy((char *)&reuse_addr_in.sin_addr, host->h_addr_list[0], host->h_length);

    if (connect(socket_fd, (struct sockaddr*)&reuse_addr_in, sizeof(reuse_addr_in)) == -1) {
        perror("Error connecting to server!");
        return -1;
    }

    /* Configure SSL context and create new connection */
    web_bio = BIO_new_socket(socket_fd, BIO_NOCLOSE);
    if (web_bio == NULL) {
        fprintf(stderr, "Error: creating a New Connection failed\n");
        return -1;
    }

    /* Set SSL context for accepting peer certificate verification */
    SSL_CTX_set_verify(ctx, SSL_VERIFY_PEER | SSL_VERIFY_FAIL_IF_NO_PEER_CERT, NULL);
    SSL *ssl = SSL_new(ctx);

    // You should also clean up OpenSSL here
    SSL_free(ssl);
    SSL_CTX_free(ctx);
    BIO_free(web_bio);
    close(socket_fd);

    return 0;
}