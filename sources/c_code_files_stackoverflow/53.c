#include <openssl/evp.h>
#include <openssl/asn1.h>

int EVP_CIPHER_set_asn1_iv(EVP_CIPHER_CTX *c, ASN1_TYPE *type)
{
    int i = 0, j;

    if (type != NULL)
    {
        j = EVP_CIPHER_CTX_iv_length(c);
        OPENSSL_assert(j <= sizeof c->iv);
        i = ASN1_TYPE_set_octetstring(type, c->oiv, j);
    }
    return(i);
}