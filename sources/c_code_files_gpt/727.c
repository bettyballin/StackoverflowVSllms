#include <stdio.h>
#include <zlib.h>
#include <string.h> // for strlen

void saveCompressedHtmlFile(const char *filename, const char *str) {
    // Open the file for writing in binary mode with compression
    gzFile gzfile = gzopen(filename, "wb");
    if (!gzfile) {
        perror("gzopen");
        return;
    }

    // Write the string to the gzfile
    if (gzwrite(gzfile, str, strlen(str)) == 0) {
        int err_no;
        const char *err_str = gzerror(gzfile, &err_no);
        if (err_no) {
            fprintf(stderr, "gzwrite error: %s\n", err_str);
        }
    }

    // Close the gzfile
    if (gzclose(gzfile) != Z_OK) {
        fprintf(stderr, "gzclose error\n");
    }
}

int main() {
    const char *outputFile = "<html><body><h1>Hello, World!</h1></body></html>";
    saveCompressedHtmlFile("index.html.gz", outputFile);
    return 0;
}