#include <stdio.h>
#include <stdlib.h>
#include <lzma.h>

/*
 * Decompresses using LZMA decoding the data decompressed into outbuffer which has size bytes.
 */
size_t lzmadecode(unsigned char *inbuffer, size_t insize, unsigned char *outbuffer, size_t outsize) {
    // Initialize a LZMA handle with no files, for decoding
    lzma_stream strm = LZMA_STREAM_INIT;

    /* Decode the file. */
    strm.next_in  = inbuffer;
    strm.avail_in = insize;
    strm.next_out = outbuffer;
    strm.avail_out = outsize;

    int r = lzma_code(&strm, LZMA_RUN);

    /* Close and free the handle */
    lzma_end (&strm);

    if (r == LZMA_OK) {
        /* Successful decompression */
        return outsize - strm.avail_out;
    } else if (r == LZMA_STREAM_END) {
        // Decompressed successfully
        return insize;
    } else {
        // Error: Invalid lzma code, corrupted data....
        return 0;
    }
}

int main() {
    unsigned char inbuffer[1024];
    unsigned char outbuffer[1024];
    size_t insize = 1024;
    size_t outsize = 1024;

    size_t decoded_size = lzmadecode(inbuffer, insize, outbuffer, outsize);

    printf("Decoded size: %zu\n", decoded_size);

    return 0;
}