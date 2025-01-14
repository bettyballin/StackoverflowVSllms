#include <stdio.h>
#include <openssl/ssl.h>
#include <openssl/err.h>

void check_cert(X509 *err_cert, int ok) {
    if (!ok) {               /* certificate verification failed */
        char errorbuf[256];
        ERR_error_string(ERR_get_error(), errorbuf);
        fprintf(stderr, "certificate check failed: %s\n", errorbuf);
        // or handle failure in another way according to the specific use case.
    } else {
        printf("Certificate Verification Is passed successfully\n");
    }
}

int main() {
    // This is a placeholder, in a real application you would have
    // a certificate loaded and passed to check_cert
    X509 *err_cert = NULL;
    int ok = 1; // Placeholder value, replace with actual result of SSL_get_verify_result()

    check_cert(err_cert, ok);

    return 0;
}