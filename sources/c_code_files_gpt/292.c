#include <stdio.h>
#include <string.h>
#include "lz4.h"

int main() {
    // Sample data to compress
    const char* src = "This is a sample text to be compressed using LZ4 compression algorithm.";
    int src_size = strlen(src) + 1;  // Include null terminator

    // Allocate memory for compressed data
    int max_dst_size = LZ4_compressBound(src_size);
    char* compressed_data = (char*)malloc(max_dst_size);

    // Compress the data
    int compressed_size = LZ4_compress_default(src, compressed_data, src_size, max_dst_size);
    if (compressed_size <= 0) {
        printf("Compression failed!\n");
        free(compressed_data);
        return 1;
    }

    printf("Original size: %d, Compressed size: %d\n", src_size, compressed_size);

    // Allocate memory for decompressed data
    char* decompressed_data = (char*)malloc(src_size);

    // Decompress the data
    int decompressed_size = LZ4_decompress_safe(compressed_data, decompressed_data, compressed_size, src_size);
    if (decompressed_size < 0) {
        printf("Decompression failed!\n");
        free(compressed_data);
        free(decompressed_data);
        return 1;
    }

    printf("Decompressed size: %d, Decompressed text: %s\n", decompressed_size, decompressed_data);

    // Clean up
    free(compressed_data);
    free(decompressed_data);

    return 0;
}