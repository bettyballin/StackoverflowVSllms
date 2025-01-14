#include <openssl/ssl.h>
#include <openssl/err.h>

int main() {
    // Initialize OpenSSL
    SSL_library_init();
    SSL_load_error_strings();
    OpenSSL_add_all_algorithms();

    return 0;
}