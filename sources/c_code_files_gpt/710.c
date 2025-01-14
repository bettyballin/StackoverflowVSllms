#include <libavformat/avformat.h>
#include <libavcodec/avcodec.h>
#include <stdio.h> // Include stdio.h for fprintf

int main(int argc, char *argv[]) {
    av_register_all();

    AVFormatContext *formatContext = avformat_alloc_context();
    if (!formatContext) {
        fprintf(stderr, "Could not allocate format context\n");
        return -1;
    }

    if (avformat_open_input(&formatContext, "input.mp3", NULL, NULL) != 0) {
        fprintf(stderr, "Could not open input file\n");
        return -1;
    }

    if (avformat_find_stream_info(formatContext, NULL) < 0) {
        fprintf(stderr, "Could not find stream information\n");
        return -1;
    }

    av_dump_format(formatContext, 0, "input.mp3", 0);

    avformat_close_input(&formatContext);
    avformat_free_context(formatContext);

    return 0;
}