#include <zlib.h>
#include <stdio.h>
#include <stdlib.h>

void saveCompressedTextFile(const char *filename, const char *str){
    // Note: The 'filename' parameter is not used in the original function.
    // It seems there might have been an intention to use it with fopen and then fileno.
    // However, to keep the functionality unchanged, I'll leave it as is.

    gzFile zf = gzdopen(fileno(stdout), "wb");

    if (zf == NULL) {
        // Handle error here
        fprintf(stderr, "Error opening output stream for compression.\n");
        return;
    }

    int ret = Z_OK;
    while (*str && (ret = gzputc(zf, *str++)) != EOF && ret != Z_STREAM_ERROR);

    if (gzclose(zf) == Z_ERRNO || ret == EOF) {
        // Handle error here as well
        fprintf(stderr, "Error during compression or closing the compressed stream.\n");
    }
}

int main() {
    const char *testString = "Hello, World!";
    saveCompressedTextFile("unused_filename.txt", testString);
    return 0;
}