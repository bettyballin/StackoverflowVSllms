#include <openssl/bio.h>
#include <openssl/evp.h>
#include <openssl/pem.h>
#include <openssl/x509.h>
#include <openssl/x509v3.h>
#include <openssl/err.h> // Add this include for error handling
#include <stdio.h> // Add this include for file operations

int main() {
    int ret = 0;

    // Initialize OpenSSL
    OpenSSL_add_all_algorithms();
    ERR_load_BIO_strings();
    ERR_load_crypto_strings();

    // Generate key pair
    EVP_PKEY *pkey = EVP_PKEY_new();
    RSA *rsa = RSA_generate_key(2048, RSA_F4, NULL, NULL);
    EVP_PKEY_assign_RSA(pkey, rsa);

    // Create X509 certificate
    X509 *x509 = X509_new();
    ASN1_INTEGER_set(X509_get_serialNumber(x509), 1);
    X509_gmtime_adj(X509_get_notBefore(x509), 0);
    X509_gmtime_adj(X509_get_notAfter(x509), 31536000L); // Valid for 1 year
    X509_set_pubkey(x509, pkey);

    // Set the subject name
    X509_NAME *name = X509_get_subject_name(x509);
    X509_NAME_add_entry_by_txt(name, "C", MBSTRING_ASC, (unsigned char *)"US", -1, -1, 0);
    X509_NAME_add_entry_by_txt(name, "O", MBSTRING_ASC, (unsigned char *)"My Organization", -1, -1, 0);
    X509_NAME_add_entry_by_txt(name, "CN", MBSTRING_ASC, (unsigned char *)"localhost", -1, -1, 0);
    X509_set_issuer_name(x509, name); // Self-signed

    // Sign the certificate
    X509_sign(x509, pkey, EVP_sha256());

    // Write the private key to a file
    FILE *pkey_file = fopen("private_key.pem", "wb");
    PEM_write_PrivateKey(pkey_file, pkey, NULL, NULL, 0, NULL, NULL);
    fclose(pkey_file);

    // Write the certificate to a file
    FILE *x509_file = fopen("certificate.pem", "wb");
    PEM_write_X509(x509_file, x509);
    fclose(x509_file);

    // Clean up
    X509_free(x509);
    EVP_PKEY_free(pkey);
    CRYPTO_cleanup_all_ex_data();
    ERR_free_strings();

    return ret;
}