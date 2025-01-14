#include <stdio.h>
#include <string.h>
#include <zlib.h>

int main() {
    char source[] = "Hello, world!";
    char dest[100];
    uLong sourceLen = strlen(source);
    uLong destLen = sizeof(dest);

    // Compress the data
    if (compress((Bytef *)dest, &destLen, (Bytef *)source, sourceLen) != Z_OK) {
        fprintf(stderr, "Compression failed\n");
        return 1;
    }

    printf("Compressed data: %s\n", dest);

    // Decompress the data
    char decompressed[100];
    uLong decompressedLen = sizeof(decompressed);
    if (uncompress((Bytef *)decompressed, &decompressedLen, (Bytef *)dest, destLen) != Z_OK) {
        fprintf(stderr, "Decompression failed\n");
        return 1;
    }

    printf("Decompressed data: %s\n", decompressed);

    return 0;
}