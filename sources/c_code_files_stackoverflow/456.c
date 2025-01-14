#include <stdio.h>
#include <string.h>
#include <stdint.h>

#define SHA1_HASH_SIZE 20
#define PVERSION41_CHAR '*'

typedef struct {
    uint32_t h0, h1, h2, h3, h4;
    uint32_t n;
    uint8_t data[64];
} SHA1_CONTEXT;

void mysql_sha1_reset(SHA1_CONTEXT *ctx) {
    ctx->h0 = 0x67452301;
    ctx->h1 = 0xEFCDAB89;
    ctx->h2 = 0x98BADCFE;
    ctx->h3 = 0x10325476;
    ctx->h4 = 0xC3D2E1F0;
    ctx->n = 0;
}

void mysql_sha1_input(SHA1_CONTEXT *ctx, uint8_t *data, uint32_t len) {
    uint32_t i;

    for (i = 0; i < len; i++) {
        ctx->data[ctx->n++] = data[i];
        if (ctx->n == 64) {
            // Process the block
            uint32_t w[16];
            uint32_t a, b, c, d, e;
            uint32_t f, k;

            for (i = 0; i < 16; i++)
                w[i] = ((uint32_t*)ctx->data)[i];

            a = ctx->h0;
            b = ctx->h1;
            c = ctx->h2;
            d = ctx->h3;
            e = ctx->h4;

            for (i = 0; i < 80; i++) {
                if (i < 16)
                    f = (b & c) | ((~b) & d);
                else if (i < 40)
                    f = b ^ c ^ d;
                else if (i < 60)
                    f = (b & c) | (b & d) | (c & d);
                else
                    f = b ^ c ^ d;

                if (i < 20)
                    k = 0x5A827999;
                else if (i < 40)
                    k = 0x6ED9EBA1;
                else if (i < 60)
                    k = 0x8F1BBCDC;
                else
                    k = 0xCA62C1D6;

                uint32_t temp = (a << 5) | (a >> 27);
                temp += f + e + k + w[i % 16];
                e = d;
                d = c;
                c = b << 30 | b >> 2;
                b = a;
                a = temp;

                if (i >= 16) {
                    w[i % 16] = (w[(i-3) % 16] ^ w[(i-8) % 16] ^ w[(i-14) % 16] ^ w[(i-16) % 16]);
                    w[i % 16] = (w[i % 16] << 1) | (w[i % 16] >> 31);
                }
            }

            ctx->h0 += a;
            ctx->h1 += b;
            ctx->h2 += c;
            ctx->h3 += d;
            ctx->h4 += e;

            ctx->n = 0;
        }
    }
}

void mysql_sha1_result(SHA1_CONTEXT *ctx, uint8_t *digest) {
    // Pad the data and process the last block
    ctx->data[ctx->n++] = 0x80;

    while (ctx->n < 56)
        ctx->data[ctx->n++] = 0;

    ((uint32_t*)ctx->data)[14] = ctx->n << 3;
    mysql_sha1_input(ctx, ctx->data, 64);

    // Copy the result to the digest
    digest[0] = (ctx->h0 >> 24) & 0xFF;
    digest[1] = (ctx->h0 >> 16) & 0xFF;
    digest[2] = (ctx->h0 >> 8) & 0xFF;
    digest[3] = ctx->h0 & 0xFF;

    digest[4] = (ctx->h1 >> 24) & 0xFF;
    digest[5] = (ctx->h1 >> 16) & 0xFF;
    digest[6] = (ctx->h1 >> 8) & 0xFF;
    digest[7] = ctx->h1 & 0xFF;

    digest[8] = (ctx->h2 >> 24) & 0xFF;
    digest[9] = (ctx->h2 >> 16) & 0xFF;
    digest[10] = (ctx->h2 >> 8) & 0xFF;
    digest[11] = ctx->h2 & 0xFF;

    digest[12] = (ctx->h3 >> 24) & 0xFF;
    digest[13] = (ctx->h3 >> 16) & 0xFF;
    digest[14] = (ctx->h3 >> 8) & 0xFF;
    digest[15] = ctx->h3 & 0xFF;

    digest[16] = (ctx->h4 >> 24) & 0xFF;
    digest[17] = (ctx->h4 >> 16) & 0xFF;
    digest[18] = (ctx->h4 >> 8) & 0xFF;
    digest[19] = ctx->h4 & 0xFF;
}

void octet2hex(char *to, const char *octet, int len) {
    for (int i = 0; i < len; i++) {
        sprintf(to + 2 * i, "%02X", (uint8_t)octet[i]);
    }
}

void make_scrambled_password(char *to, const char *password) {
    SHA1_CONTEXT sha1_context;
    uint8_t hash_stage2[SHA1_HASH_SIZE];

    mysql_sha1_reset(&sha1_context);
    mysql_sha1_input(&sha1_context, (uint8_t*)password, strlen(password));
    mysql_sha1_result(&sha1_context, (uint8_t*)to);

    mysql_sha1_reset(&sha1_context);
    mysql_sha1_input(&sha1_context, (uint8_t*)to, SHA1_HASH_SIZE);
    mysql_sha1_result(&sha1_context, hash_stage2);

    *to++ = PVERSION41_CHAR;
    octet2hex(to, (const char*)hash_stage2, SHA1_HASH_SIZE);
}

int main() {
    char password[] = "your_password";
    char scrambled_password[2 * SHA1_HASH_SIZE + 2];

    make_scrambled_password(scrambled_password, password);

    printf("Scrambled password: %s\n", scrambled_password);

    return 0;
}