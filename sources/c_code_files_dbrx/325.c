#include <stdlib.h>

int main() {
    // The pdf filename and the output text filename.
    const char* pdf_filename = "<pdf_file_name>";
    const char* txt_filename = "<out_text_file_name>";

    // Extract plain text from the PDF with pdftotext utility.
    int result = system(0);
    char cmd[256];
    snprintf(cmd, 256, "pdftotext %s %s", pdf_filename, txt_filename);
    if ((result = system(cmd)) != 0) {
        perror("pdftotext failed");
        exit(-1);
    }

    return 0;
}