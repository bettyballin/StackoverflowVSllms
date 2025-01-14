#include <openssl/ssl.h>
#include <openssl/err.h>

int main() {
    const char *certFilePath = "path/to/cert.pem";
    const char *caFilePath = "path/to/ca.pem";
    const char *pkeyFilePath = "path/to/pkey.pem";

    SSL_CTX *ctx = SSL_CTX_new(SSLv23_server_method()); // Create a new context
    if (NULL == ctx) {
        ERR_print_errors_fp(stderr);
        return 1;
    }

    // Load the certificate file for server authentication purposes.
    if (!SSL_CTX_use_certificate_file(ctx, certFilePath, SSL_FILETYPE_PEM)) {
        ERR_print_errors_fp(stderr);
        SSL_CTX_free(ctx);
        return 1;
    }

    // Make sure that only clients with a trusted CA will connect to your sever by specifying this path and file.
    X509_VERIFY_PARAM *param = SSL_CTX_get0_param(ctx); // set up params; add cert verification checks if needed)
    if (!SSL_CTX_load_verify_locations(ctx, caFilePath, NULL)) {
        ERR_print_errors_fp(stderr);
        SSL_CTX_free(ctx);
        return 1;
    }

    // Make sure to load the private key also
    if (!SSL_CTX_use_PrivateKey_file(ctx, pkeyFilePath, SSL_FILETYPE_PEM)) {
        ERR_print_errors_fp(stderr);
        SSL_CTX_free(ctx);
        return 1;
    }

    // Clean up
    SSL_CTX_free(ctx);
    return 0;
}