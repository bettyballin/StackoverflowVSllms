#include <libavcodec/avcodec.h> // Library to decode / encode videos or sound samples
#include <libavformat/avformat.h> // Library for loading / storing multimedia files into memory.

int main(int argc, char **argv) {
    if (argc < 2) {
        fprintf(stderr, "Usage: %s <input_file>\n", argv[0]);
        return -1;
    }

    AVFormatContext *input_context = NULL;
    avcodec_register_all();    /* This registers all the encoding and decoding libraries */
    avformat_network_init();   /* Initializes network module. */

    if (avformat_open_input(&input_context, argv[1], NULL, NULL) != 0) {
        fprintf(stderr, "Error opening input file\n");
        return -1;
    }

    if (avformat_find_stream_info(input_context, NULL) < 0) {
        fprintf(stderr, "Error finding stream info\n");
        return -1;
    }

    AVCodecContext *dec_ctx = input_context->streams[av_find_best_stream(input_context, AVMEDIA_TYPE_AUDIO, -1, -1, NULL, 0)]->codec;
    AVCodec *codec = avcodec_find_decoder(dec_ctx->codec_id);
    if (!codec) {
        fprintf(stderr, "Error finding decoder\n");
        return -1;
    }

    if (avcodec_open2(dec_ctx, codec, NULL) != 0) {
        fprintf(stderr, "Error opening decoder\n");
        return -1;
    }

    int frames_read;
    for (int i = 0, ret = 1; ret > 0; ) {
        AVFrame *frame = av_frame_alloc();
        ret = av_read_frame(input_context, frame);
        if (ret < 0) {
            fprintf(stderr, "Error reading frame\n");
            break;
        }

        uint8_t *buffer;
        av_frame_make_writable(frame);
        buffer = frame->data[0];

        int result = decode(input_context, dec_ctx, &buffer);
        // ...

        av_frame_free(&frame);
    }

    avcodec_close(dec_ctx);
    avformat_close_input(&input_context);
    return 0;
}