#include <stdio.h>\n#include <string.h>\n#include <openssl/ssl.h>\n#include <openssl/err.h>\n\n#define POP3_PORT 995\n#define POP3_SERVER "your_pop3_server"\n#define USERNAME "your_username"\n#define PASSWORD "your_password"\n\nint main() {\n    SSL_CTX *ctx;\n    SSL *ssl;\n    BIO *bio;\n    int sockfd;\n\n    // Initialize OpenSSL\n    SSL_library_init();\n    ERR_load_crypto_strings();\n\n    // Create a new SSL context\n    ctx = SSL_CTX_new(TLS_client_method());\n    if (!ctx) {\n        ERR_print_errors_fp(stderr);\n        return 1;\n    }\n\n    // Create a new SSL object\n    ssl = SSL_new(ctx);\n    if (!ssl) {\n        ERR_print_errors_fp(stderr);\n        SSL_CTX_free(ctx);\n        return 1;\n    }\n\n    // Create a new BIO object for the socket\n    bio = BIO_new_connect(POP3_SERVER ":" POP3_PORT);\n    if (!bio) {\n        ERR_print_errors_fp(stderr);\n        SSL_free(ssl);\n        SSL_CTX_free(ctx);\n        return 1;\n    }\n\n    // Set up the SSL object for the connection\n    SSL_set_bio(ssl, bio, bio);\n\n    // Connect to the POP3 server\n    if (SSL_connect(ssl) <= 0) {\n        ERR_print_errors_fp(stderr);\n        SSL_free(ssl);\n        SSL_CTX_free(ctx);\n        return 1;\n    }\n\n    // Authenticate with the POP3 server\n    char auth_cmd[256];\n    sprintf(auth_cmd, "USER %s\r\n", USERNAME);\n    SSL_write(ssl, auth_cmd, strlen(auth_cmd));\n    sprintf(auth_cmd, "PASS %s\r\n", PASSWORD);\n    SSL_write(ssl, auth_cmd, strlen(auth_cmd));\n\n    // Fetch mail\n    char cmd[256];\n    sprintf(cmd, "LIST\r\n");\n    SSL_write(ssl, cmd, strlen(cmd));\n    char buffer[1024];\n    SSL_read(ssl, buffer, 1024);\n    printf("%s", buffer);\n\n    // Close the connection\n    SSL_shutdown(ssl);\n    SSL_free(ssl);\n    SSL_CTX_free(ctx);\n\n    return 0;\n}