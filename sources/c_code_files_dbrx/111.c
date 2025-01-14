#include <openssl/bio.h>
#include <openssl/ssl.h>
#include <string.h>
#include <stdio.h>
#include <sys/socket.h>

int main() {
    // Initialize the OpenSSL library
    SSL_library_init();
    SSL_load_error_strings();
    const SSL_METHOD *method = TLSv1_client_method();
    SSL_CTX *ctx = SSL_CTX_new(method);

    if (ctx == NULL) {
        printf("Unable to create a new context\n");
        return 1;
    }

    // Create an SSL connection from the context
    BIO *bio = BIO_new_ssl_connect(ctx);
    BIO_set_conn_hostname(bio, "pop3.example.com:995");

    if (BIO_do_handshake(bio) <= 0) {
        printf("Error in connection\n");
        return 1;
    } else {
        char sendBuf[] = "+OK POP3 server ready\r\n";
        BIO_puts(bio, "USER username\r\n");
        BIO_gets(bio, sendBuf, sizeof(sendBuf));
        // Add here other commands as needed like 'PASS' and 'RETR'. Don't forget to close your SSL connection correctly.
    }

    // Clean up
    BIO_free_all(bio);
    SSL_CTX_free(ctx);

    return 0;
}