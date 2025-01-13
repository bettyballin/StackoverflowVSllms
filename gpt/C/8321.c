#include <stdio.h>\n#include <jpeglib.h>\n#include <stdlib.h>\n\nvoid read_JPEG_file(const char *filename) {\n    struct jpeg_decompress_struct cinfo;\n    struct jpeg_error_mgr jerr;\n    FILE *infile;\n    JSAMPARRAY buffer;\n    int row_stride;\n\n    if ((infile = fopen(filename, "rb")) == NULL) {\n        fprintf(stderr, "can't open %s\n", filename);\n        return;\n    }\n\n    cinfo.err = jpeg_std_error(&jerr);\n    jpeg_create_decompress(&cinfo);\n    jpeg_stdio_src(&cinfo, infile);\n    (void) jpeg_read_header(&cinfo, TRUE);\n    (void) jpeg_start_decompress(&cinfo);\n\n    row_stride = cinfo.output_width * cinfo.output_components;\n    buffer = (*cinfo.mem->alloc_sarray)\n        ((j_common_ptr) &cinfo, JPOOL_IMAGE, row_stride, 1);\n\n    while (cinfo.output_scanline < cinfo.output_height) {\n        (void) jpeg_read_scanlines(&cinfo, buffer, 1);\n        // Process the row (buffer[0], buffer[1], ..., buffer[row_stride-1])\n    }\n\n    (void) jpeg_finish_decompress(&cinfo);\n    jpeg_destroy_decompress(&cinfo);\n    fclose(infile);\n}\n\nint main() {\n    read_JPEG_file("example.jpg");\n    return 0;\n}