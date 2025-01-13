#include <openssl/pem.h>\n#include <openssl/x509.h>\n#include <openssl/err.h>\n\nint main() {\n    RSA *rsa = NULL;\n    EVP_PKEY *pkey = EVP_PKEY_new();\n    \n    // Assuming rsa is your 1024-bit RSA key pair loaded from PKCS#11\n    // This part will depend on how you are interfacing with PKCS#11\n    if (!EVP_PKEY_set1_RSA(pkey, rsa)) {\n        printf("Error setting RSA key\n");\n        return -1;\n    }\n\n    X509_REQ *req = X509_REQ_new();\n    X509_NAME *name;\n\n    /* Build request */\n    name  = X509_REQ_get_subject_name(req);\n\n    // Set the subject details\n    X509_NAME_add_entry_by_txt(name, "C", MBSTRING_ASC,\n                                 (unsigned char *)"US", -1, -1, 0);\n    X509_NAME_add_entry_by_txt(name, "O", MBSTRING_ASC,\n                                 (unsigned char *)"My Organization",\n                                 -1, -1, 0);\n    X509_NAME_add_entry_by_txt(name, "CN", MBSTRING_ASC,\n                                 (unsigned char *)"My Common Name or FQDN",\n                                 -1, -1, 0);\n\n    // Set the public key\n    if (!X509_REQ_set_pubkey(req,pkey)) {\n        printf("Error setting public key\n");\n        return -1;\n    }\n\n    // Sign it up with private key\n    if (!X509_REQ_sign(req, pkey, EVP_sha256())) {\n        printf("Error signing request\n");\n        return -1;\n    }\n\n    // Write it out to a file\n    BIO *bio = BIO_new_file("req.pem", "w");\n    if (bio == NULL) {\n        perror("Failed opening output file for writing");\n        return -1;\n    }\n    PEM_write_bio_X509_REQ(bio, req);\n    BIO_free_all(bio);\n\n    X509_REQ_free(req);\n    EVP_PKEY_free(pkey);\n    RSA_free(rsa);\n   \n    // Clean up\n    ERR_free_strings();\n\n    return 0;\n}