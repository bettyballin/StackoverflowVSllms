#include <stdio.h>
#include <stdlib.h>
#include <lzo/lzo1x.h>

#define IN_LEN (128 * 1024)  // Adjust buffer size as needed
#define OUT_LEN (IN_LEN + IN_LEN / 16 + 64 + 3)  // Sufficient output buffer size

int main() {
    char buffer[IN_LEN];
    char outbuffer[OUT_LEN];
    int read;
    lzo_uint writ;
    unsigned long totalWrit = 0;
    int r;

    if (lzo_init() != LZO_E_OK) {
        fprintf(stderr, "LZO initialization failed\n");
        return 1;
    }

    FILE *input = stdin;
    FILE *output = stdout;

    while ((read = fread(buffer, sizeof(char), IN_LEN, input)) > 0) {
        r = lzo1x_decompress(buffer, read, outbuffer, &writ, NULL);
        if (r != LZO_E_OK) {
            fprintf(stderr, "Decompression failed: %d\n", r);
            return 1;
        }

        if (fwrite(outbuffer, sizeof(char), writ, output) != writ) {
            fprintf(stderr, "Write error\n");
            return 1;
        }

        totalWrit += writ;
    }

    if (ferror(input)) {
        fprintf(stderr, "Read error\n");
        return 1;
    }

    fprintf(stderr, "\nDone. %lu bytes written out.\n", totalWrit);
    return 0;
}