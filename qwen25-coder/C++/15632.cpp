#include "stdafx.h"\n#include <stdio.h>\n#include <assert.h>\n#include <jpeglib.h>\n\nint _tmain(int argc, _TCHAR* argv[])\n{\n    struct jpeg_decompress_struct cinfo;\n    struct jpeg_error_mgr jerr;\n    FILE * infile;\n\n    // Step 1: Initialize error handling\n    cinfo.err = jpeg_std_error(&jerr);\n\n    // Step 2: Initialize the decompression object\n    jpeg_create_decompress(&cinfo);\n\n    // Step 3: Open a file for reading\n    errno_t err = fopen_s(&infile, "..\\Sample.jpg", "rb");\n    assert(err == 0 && infile != NULL);\n\n    // Step 4: Specify data source (eg, a file)\n    jpeg_stdio_src(&cinfo, infile);\n\n    // Step 5: Read file parameters with jpeg_read_header()\n    (void)jpeg_read_header(&cinfo, TRUE);\n\n    // Step 6: Set parameters for decompression\n    // Example: disable smoothing\n    cinfo.dct_method = JDCT_IFAST;\n\n    // Step 7: Start decompressor\n    (void)jpeg_start_decompress(&cinfo);\n    int row_stride = cinfo.output_width * cinfo.output_components;\n\n    // Step 8: Process data\n    // JSAMPARRAY buffer is a pointer to an array of pointers to rows. Make a JSAMPLE-sized array of pointers to JSAMPLE rows.\n    JSAMPARRAY buffer = (*cinfo.mem->alloc_sarray)\n                    ((j_common_ptr) &cinfo, JPOOL_IMAGE, row_stride, 1);\n\n    // Step 9: While (scan lines remain to be read)\n    while (cinfo.output_scanline < cinfo.output_height) {\n        // jpeg_read_scanlines expects an array of pointers to scanlines.\n        // Here the array is only one element long, but you could ask for\n        // more than one scanline at a time if that's more convenient.\n        (void)jpeg_read_scanlines(&cinfo, buffer, 1);\n        // Assume put_scanline_someplace wants a pointer and sample count.\n    }\n\n    // Step 10: Finish decompression\n    (void)jpeg_finish_decompress(&cinfo);\n\n    // Step 11: Release JPEG decompression object\n    jpeg_destroy_decompress(&cinfo);\n\n    // Step 12: Close file\n    fclose(infile);\n\n    return 0;\n}