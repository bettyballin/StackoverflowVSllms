#include <zip.h>
#include <stdio.h>

int main() {
    int err = 0;
    zip_t *archive = zip_open("output.zip", ZIP_CREATE | ZIP_TRUNCATE, &err);
    if (archive == NULL) {
        fprintf(stderr, "Failed to create archive: %s\n", zip_strerror(archive));
        return 1;
    }

    const char *files[] = {"file1.txt", "file2.txt"};
    for (int i = 0; i < sizeof(files) / sizeof(files[0]); ++i) {
        zip_source_t *source = zip_source_file(archive, files[i], 0, 0);
        if (source == NULL || zip_file_add(archive, files[i], source, ZIP_FL_OVERWRITE) < 0) {
            fprintf(stderr, "Failed to add file: %s\n", zip_strerror(archive));
            zip_source_free(source);
            zip_close(archive);
            return 1;
        }
    }

    if (zip_close(archive) < 0) {
        fprintf(stderr, "Failed to finalize archive: %s\n", zip_strerror(archive));
        return 1;
    }

    return 0;
}