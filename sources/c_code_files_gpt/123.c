#include <stdio.h>
#include <stdlib.h>
#include <mpg123.h>

#define BUFFER_SIZE 4096

int main(int argc, char *argv[]) {
    if (argc < 2) {
        fprintf(stderr, "Usage: %s <input_mp3>\n", argv[0]);
        return 1;
    }

    const char *input_file = argv[1];
    mpg123_handle *mh;
    unsigned char buffer[BUFFER_SIZE];
    size_t done;
    int err;

    // Initialize mpg123 library
    if (mpg123_init() != MPG123_OK) {
        fprintf(stderr, "Unable to initialize mpg123 library\n");
        return 1;
    }

    // Create a new mpg123 handle
    mh = mpg123_new(NULL, &err);
    if (mh == NULL) {
        fprintf(stderr, "Unable to create mpg123 handle: %s\n", mpg123_plain_strerror(err));
        mpg123_exit();
        return 1;
    }

    // Open the MP3 file
    if (mpg123_open(mh, input_file) != MPG123_OK) {
        fprintf(stderr, "Unable to open input file: %s\n", mpg123_strerror(mh));
        mpg123_delete(mh);
        mpg123_exit();
        return 1;
    }

    // Retrieve format information
    long rate;
    int channels, encoding;
    if (mpg123_getformat(mh, &rate, &channels, &encoding) != MPG123_OK) {
        fprintf(stderr, "Unable to get format information: %s\n", mpg123_strerror(mh));
        mpg123_close(mh);
        mpg123_delete(mh);
        mpg123_exit();
        return 1;
    }

    // Set the output format to 16-bit PCM
    mpg123_format_none(mh);
    mpg123_format(mh, rate, channels, MPG123_ENC_SIGNED_16);

    // Decode the MP3 file
    while (mpg123_read(mh, buffer, BUFFER_SIZE, &done) == MPG123_OK) {
        fwrite(buffer, 1, done, stdout);
    }

    // Cleanup
    mpg123_close(mh);
    mpg123_delete(mh);
    mpg123_exit();

    return 0;
}