#include <stdio.h>\n#include <stdlib.h>\n#include <mpg123.h>\n\n#define BUFFER_SIZE 4096\n\nint main(int argc, char *argv[]) {\n    if (argc < 2) {\n        fprintf(stderr, "Usage: %s <input_mp3>\n", argv[0]);\n        return 1;\n    }\n\n    const char *input_file = argv[1];\n    mpg123_handle *mh;\n    unsigned char buffer[BUFFER_SIZE];\n    size_t done;\n    int err;\n\n    // Initialize mpg123 library\n    if (mpg123_init() != MPG123_OK) {\n        fprintf(stderr, "Unable to initialize mpg123 library\n");\n        return 1;\n    }\n\n    // Create a new mpg123 handle\n    mh = mpg123_new(NULL, &err);\n    if (mh == NULL) {\n        fprintf(stderr, "Unable to create mpg123 handle: %s\n", mpg123_plain_strerror(err));\n        mpg123_exit();\n        return 1;\n    }\n\n    // Open the MP3 file\n    if (mpg123_open(mh, input_file) != MPG123_OK) {\n        fprintf(stderr, "Unable to open input file: %s\n", mpg123_strerror(mh));\n        mpg123_delete(mh);\n        mpg123_exit();\n        return 1;\n    }\n\n    // Retrieve format information\n    long rate;\n    int channels, encoding;\n    if (mpg123_getformat(mh, &rate, &channels, &encoding) != MPG123_OK) {\n        fprintf(stderr, "Unable to get format information: %s\n", mpg123_strerror(mh));\n        mpg123_close(mh);\n        mpg123_delete(mh);\n        mpg123_exit();\n        return 1;\n    }\n\n    // Set the output format to 16-bit PCM\n    mpg123_format_none(mh);\n    mpg123_format(mh, rate, channels, MPG123_ENC_SIGNED_16);\n\n    // Decode the MP3 file\n    while (mpg123_read(mh, buffer, BUFFER_SIZE, &done) == MPG123_OK) {\n        fwrite(buffer, 1, done, stdout);\n    }\n\n    // Cleanup\n    mpg123_close(mh);\n    mpg123_delete(mh);\n    mpg123_exit();\n\n    return 0;\n}