#include <stdio.h>
#include <stdlib.h>
#include <jpeglib.h>
#include <setjmp.h>

int main() {
    // Read JPEG file
    FILE *input = fopen("input.jpg", "rb");
    if (input == NULL) {
        fprintf(stderr, "Error opening input file\n");
        return 1;
    }

    // Decompress JPEG file
    struct jpeg_decompress_struct dinfo;
    struct jpeg_error_mgr jerr;
    dinfo.err = jpeg_std_error(&jerr);
    jpeg_create_decompress(&dinfo);
    jpeg_stdio_src(&dinfo, input);
    jpeg_read_header(&dinfo, TRUE);
    jpeg_start_decompress(&dinfo);

    int width = dinfo.output_width;
    int height = dinfo.output_height;
    int num_components = dinfo.output_components;

    // Allocate buffer for decompressed image
    size_t row_stride = width * num_components;
    JSAMPLE *image_buffer = (JSAMPLE *)malloc(row_stride * height);
    if (image_buffer == NULL) {
        fprintf(stderr, "Error allocating memory for image buffer\n");
        jpeg_destroy_decompress(&dinfo);
        fclose(input);
        return 1;
    }

    // Read scanlines
    while (dinfo.output_scanline < dinfo.output_height) {
        JSAMPROW row_pointer[1];
        row_pointer[0] = &image_buffer[dinfo.output_scanline * row_stride];
        jpeg_read_scanlines(&dinfo, row_pointer, 1);
    }

    jpeg_finish_decompress(&dinfo);
    jpeg_destroy_decompress(&dinfo);
    fclose(input);

    // Compress JPEG file
    struct jpeg_compress_struct cinfo;
    cinfo.err = jpeg_std_error(&jerr);
    jpeg_create_compress(&cinfo);

    FILE *outfile = fopen("foo.jpg", "wb");
    if (outfile == NULL) {
        fprintf(stderr, "Error opening output file\n");
        free(image_buffer);
        return 1;
    }

    jpeg_stdio_dest(&cinfo, outfile);

    cinfo.image_width = width;
    cinfo.image_height = height;
    cinfo.input_components = num_components;
    cinfo.in_color_space = JCS_RGB;

    jpeg_set_defaults(&cinfo);
    jpeg_start_compress(&cinfo, TRUE);

    while (cinfo.next_scanline < cinfo.image_height) {
        JSAMPROW row_pointer[1];
        row_pointer[0] = &image_buffer[cinfo.next_scanline * row_stride];
        jpeg_write_scanlines(&cinfo, row_pointer, 1);
    }

    jpeg_finish_compress(&cinfo);

    // Cleanup
    fclose(outfile);
    jpeg_destroy_compress(&cinfo);
    free(image_buffer);

    return 0;
}