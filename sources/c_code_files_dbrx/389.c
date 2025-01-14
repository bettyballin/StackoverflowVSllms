#include <stdio.h>
#include <openssl/ssl.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

int main() {
    SSL *ssl = NULL;
    SSL_CTX *ctx = NULL;
    int sck = 0;
    struct sockaddr_in addr;

    // Initialize OpenSSL library
    SSL_library_init();
    OpenSSL_add_all_algorithms();
    SSL_load_error_strings();
    ctx = SSL_CTX_new(TLSv1_2_client_method());

    // Create a new socket
    sck = socket(AF_INET, SOCK_STREAM, 0);
    if (sck < 0) {
        perror("socket");
        return EXIT_FAILURE;
    }

    // Set up the server address
    const char *address = "127.0.0.1";
    inet_pton(AF_INET, address, &addr.sin_addr);
    addr.sin_family = AF_INET;
    addr.sin_port = htons(443);

    // Connect to the server
    if (connect(sck, (struct sockaddr *)&addr, sizeof(addr)) < 0) {
        perror("connect");
        return EXIT_FAILURE;
    }

    // Create a new SSL object
    ssl = SSL_new(ctx);
    if (!ssl) {
        printf("OpenSSL Failed\n");
        return EXIT_FAILURE;
    }

    // Associate the SSL object with the socket
    if (!SSL_set_fd(ssl, sck)) {
        printf("Error setting fd on SSL Socket\n");
        return EXIT_FAILURE;
    }

    // Do the SSL handshake
    if (SSL_connect(ssl) <= 0) {
        printf("SSL connection failed\n");
        return EXIT_FAILURE;
    }

    printf("Successfully established secure SSL Socket\n");

    // Close the resources properly
    SSL_shutdown(ssl);
    SSL_free(ssl);
    close(sck);

    return 0;
}