#include <stdio.h>
#include <string.h>
#define MINIZ_HEADER_FILE_ONLY
#include "miniz.c"

int main() {
    mz_zip_archive archive;
    memset(&archive, 0, sizeof(archive));

    if (!mz_zip_writer_init_file(&archive, "output.zip", 0)) {
        fprintf(stderr, "Failed to create archive\n");
        return 1;
    }

    const char *files[] = {"file1.txt", "file2.txt"};
    for (int i = 0; i < 2; ++i) {
        if (!mz_zip_writer_add_file(&archive, files[i], files[i], "", 0, MZ_BEST_COMPRESSION)) {
            fprintf(stderr, "Failed to add file: %s\n", files[i]);
            mz_zip_writer_end(&archive);
            return 1;
        }
    }

    mz_zip_writer_finalize_archive(&archive);
    mz_zip_writer_end(&archive);

    return 0;
}