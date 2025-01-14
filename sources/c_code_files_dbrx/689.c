#include <openssl/ssl.h>

int main() {
    const char *fallbacks[] = { "SSLv2", "SSLv3", NULL };
    OPENSSL_init_ssl(0, fallbacks);
    /* perform normal code for connecting to the server */
    return 0;
}