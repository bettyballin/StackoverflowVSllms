#include <openssl/ssl.h>
#include <openssl/x509.h>
#include <openssl/bn.h>
#include <openssl/rsa.h>
#include <openssl/pem.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SERIAL_LENGTH 16

/* Create key pair */
RSA *create_key(size_t n) {
    RSA *key = NULL;

    if ((key = RSA_generate_key(n, RSA_F4, NULL, NULL)) == NULL) {
        perror("Error generating keys.");
        ERR_print_errors_fp(stderr);
        exit(-1);
    }
    return key;
}

/* Generate certificate */
X509* generate_x509cert(RSA *rsa, int serial) {
    EVP_MD* md = EVP_md5();
    const X509_ALGOR *algorithm = algid_ssl; /* default to ssl3-style sig */
    BIGNUM bnSerial;
    time_t now = time(NULL);
    X509 *x509 = X509_new();

    /* Generate serial number */
    BN_generate_prime(&bnSerial, SERIAL_LENGTH, IS1, NULL, NULL, NULL);

    /* Set new key from rsa for certificate */
    if (rsa) X509_set_pubkey(x509, rsa);
    else {
        perror("Error setting RSA.");
        ERR_print_errors_fp(stderr);
        exit(-1);
    }

    /* Set up a 84 bits of entropy X509V3_ extensions */
    const int nid = NID_md5; // or sha256
    int i = OBJ_sn2nid("CN"); // get corresponding nid
    if (0 > i) {
        perror("Error setting SN");
        ERR_print_errors_fp(stderr);
        exit(-1);
    }

    /* Set up subject name */
    X509_NAME *subj = X509_get_subject_name(x509);
    if (!X509_NAME_add_entry_by_txt(subj, "C", MBSTRING_ASC, "Country", -1, -1, 0)) goto error;
    if (!X509_NAME_add_entry_by_txt(subj, "ST", MBSTRING_ASC, "State", -1, -1, 0)) goto error;
    if (!X509_NAME_add_entry_by_txt(subj, "L", MBSTRING_ASC, "Locality", -1, -1, 0)) goto error;
    if (!X509_NAME_add_entry_by_txt(subj, "O", MBSTRING_ASC, "Organization", -1, -1, 0)) goto error;
    if (!X509_NAME_add_entry_by_txt(subj, "CN", MBSTRING_ASC, "Common Name", -1, -1, 0)) goto error;

    /* Fill in other parameters like serial number and issuer */
    ASN1_INTEGER_set(X509_get_serialNumber(x509), serial);
    X509_set_issuer_name(x509, subj);
    X509_set_version(x509, 2); // X509v3

    return x509;

error:
    X509_free(x509);
    return NULL;
}

/* Write PEM File */
void write_Pem(FILE* fh, char *header, X509 *x) {
    PEM_write_X509(fh, x);
}

int main() {
    RSA *rsa = create_key(2048);
    X509 *x509 = generate_x509cert(rsa, 1);
    FILE *fp = fopen("cert.pem", "w");
    write_Pem(fp, "-----BEGIN CERTIFICATE-----", x509);
    fclose(fp);
    return 0;
}