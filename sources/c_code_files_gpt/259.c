#include <stdio.h>
#include "mbedtls/ssl.h"

int main() {
    mbedtls_ssl_context ssl_context;

    // Initialize mbedTLS
    mbedtls_ssl_init(&ssl_context);

    // Add your mbedTLS usage code here...

    mbedtls_ssl_free(&ssl_context);

    return 0;
}