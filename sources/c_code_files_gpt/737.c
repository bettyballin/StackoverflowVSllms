#include <stdio.h>
#include <stdlib.h>
#include <poppler/glib/poppler.h>

void extract_text_from_pdf(const char *filename) {
    GError *error = NULL;
    PopplerDocument *document = poppler_document_new_from_file(filename, NULL, &error);

    if (!document) {
        fprintf(stderr, "Error opening PDF file: %s\n", error->message);
        g_error_free(error);
        return;
    }

    int num_pages = poppler_document_get_n_pages(document);
    for (int i = 0; i < num_pages; i++) {
        PopplerPage *page = poppler_document_get_page(document, i);
        char *text = poppler_page_get_text(page);

        if (text) {
            printf("Page %d:\n%s\n", i + 1, text);
            g_free(text);
        }

        g_object_unref(page);
    }

    g_object_unref(document);
}

int main(int argc, char **argv) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <pdf-file>\n", argv[0]);
        return EXIT_FAILURE;
    }

    extract_text_from_pdf(argv[1]);

    return EXIT_SUCCESS;
}