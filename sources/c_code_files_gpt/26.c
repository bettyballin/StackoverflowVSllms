#include <openssl/ocsp.h>
#include <openssl/x509.h>
#include <openssl/pem.h>
#include <stdio.h>

int main() {
    FILE *cert_fp = fopen("cert.pem", "r");
    FILE *issuer_fp = fopen("issuer.pem", "r");
    const char *ocsp_host = "ocsp.example.com";
    const char *ocsp_path = "/path/to/ocsp";

    X509 *cert = PEM_read_X509(cert_fp, NULL, NULL, NULL);
    X509 *issuer = PEM_read_X509(issuer_fp, NULL, NULL, NULL);

    OCSP_REQUEST *req = OCSP_REQUEST_new();
    OCSP_CERTID *id = OCSP_cert_to_id(NULL, cert, issuer);
    OCSP_request_add0_id(req, id);

    BIO *bio = BIO_new_connect(ocsp_host);
    OCSP_RESPONSE *res = OCSP_sendreq_bio(bio, ocsp_path, req);

    int status = OCSP_response_status(res);
    printf("OCSP Status: %d\n", status);

    // Clean up
    OCSP_RESPONSE_free(res);
    BIO_free(bio);
    OCSP_REQUEST_free(req);
    X509_free(cert);
    X509_free(issuer);
    fclose(cert_fp);
    fclose(issuer_fp);

    return 0;
}