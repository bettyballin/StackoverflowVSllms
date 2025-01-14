#include <openssl/dh.h>
#include <openssl/engine.h>
#include <openssl/err.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void generate_dh_key_pair(DH **dh, unsigned char **pub_key, int *pub_key_len) {
    *dh = DH_new();
    DH_generate_parameters_ex(*dh, 2048, DH_GENERATOR_2, NULL);
    DH_generate_key(*dh);

    const BIGNUM *pub_key_bn = DH_get0_pub_key(*dh);
    *pub_key_len = BN_num_bytes(pub_key_bn);
    *pub_key = (unsigned char *)malloc(*pub_key_len);
    BN_bn2bin(pub_key_bn, *pub_key);
}

void compute_shared_secret(DH *dh, const unsigned char *peer_pub_key, int peer_pub_key_len, unsigned char **secret, int *secret_len) {
    BIGNUM *peer_pub_key_bn = BN_bin2bn(peer_pub_key, peer_pub_key_len, NULL);
    *secret_len = DH_size(dh);
    *secret = (unsigned char *)malloc(*secret_len);
    *secret_len = DH_compute_key(*secret, peer_pub_key_bn, dh);
    BN_free(peer_pub_key_bn);
}

int main() {
    // Generate DH key pairs for both client and server
    DH *dh_client, *dh_server;
    unsigned char *client_pub_key, *server_pub_key;
    int client_pub_key_len, server_pub_key_len;

    generate_dh_key_pair(&dh_client, &client_pub_key, &client_pub_key_len);
    generate_dh_key_pair(&dh_server, &server_pub_key, &server_pub_key_len);

    // Compute shared secrets
    unsigned char *client_secret, *server_secret;
    int client_secret_len, server_secret_len;

    compute_shared_secret(dh_client, server_pub_key, server_pub_key_len, &client_secret, &client_secret_len);
    compute_shared_secret(dh_server, client_pub_key, client_pub_key_len, &server_secret, &server_secret_len);

    // Ensure both secrets are identical
    if (client_secret_len == server_secret_len && memcmp(client_secret, server_secret, client_secret_len) == 0) {
        printf("DHKE successful and secrets match\n");
    } else {
        printf("DHKE failed or secrets do not match\n");
    }

    // Free resources
    DH_free(dh_client);
    DH_free(dh_server);
    free(client_pub_key);
    free(server_pub_key);
    free(client_secret);
    free(server_secret);

    return 0;
}