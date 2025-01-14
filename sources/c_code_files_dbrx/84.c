#include <stdio.h>
#include <string.h>
#include <zlib.h>

#define MAX_SIZE 1024
#define CHUNK 16384

int decompress_gzip(unsigned char **uncompressed_data, unsigned long *uncompressed_length, unsigned char *compressed_data, size_t compressed_size) {
    z_stream strm;
    strm.zalloc = Z_NULL;
    strm.zfree = Z_NULL;
    strm.opaque = Z_NULL;
    strm.next_in = compressed_data;
    strm.avail_in = compressed_size;

    int status = inflateInit2(&strm, 16 + MAX_WBITS);
    if (status != Z_OK) {
        return status;
    }

    *uncompressed_data = malloc(CHUNK);
    do {
        strm.avail_out = CHUNK;
        strm.next_out = *uncompressed_data + *uncompressed_length;
        status = inflate(&strm, Z_NO_FLUSH);
        if (status == Z_STREAM_ERROR) {
            free(*uncompressed_data);
            return status;
        }
        *uncompressed_length += CHUNK - strm.avail_out;
        if (strm.avail_out == 0) {
            *uncompressed_data = realloc(*uncompressed_data, *uncompressed_length + CHUNK);
        }
    } while (strm.avail_out == 0);

    inflateEnd(&strm);
    return status;
}

int main() {
    unsigned char *uncompressed_data;
    unsigned long decompressed_length = 0;
    int uncompress_status;

    // Receive $compressed_data from PHP server into a buffer here...
    unsigned char compressed_data[] = "\x1f\x8b\x08...";
    size_t compressed_size = sizeof(compressed_data);

    uncompress_status = decompress_gzip(&uncompressed_data, &decompressed_length, compressed_data, compressed_size); // Decompress data using built-in libz function
    if (uncompress_status == Z_OK) {
        printf("Decompression completed successfully.\n");
    } else {
        fprintf(stderr, "Error decompressing: %d\n", uncompress_status);
        return 1;
    }

    // Use the decompressed data here... (uncompressed_data)
    free(uncompressed_data);

    return 0;
}