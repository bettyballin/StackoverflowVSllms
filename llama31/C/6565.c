#include <zlib.h>\n\nvoid saveCompressedHtmlFile(const char *filename, const char *str) {\n    gzFile file = gzopen(filename, "wb");\n    if (file == NULL) {\n        // handle error\n    }\n\n    // Write the compressed data\n    gzwrite(file, str, strlen(str));\n\n    // Close the file\n    gzclose(file);\n}