#include <libavcodec/avcodec.h>

int main(int argc, char **argv) {
    const AVCodec *decoder;
    const AVCodecParameters* codecpar;
    AVCodecContext *codec_ctx_video = avcodec_alloc_context3(NULL);
    uint8_t endcode[] = { 0x00, 0x00, 0x01, 0x09 }; //end of sequence tag in h264 stream
    int result;

    // Initialize libavcodec
    avcodec_register_all();

    decoder = avcodec_find_decoder(AV_CODEC_ID_H264);
    if (!decoder) {
        // Log & handle error.
        return 1;
    }

    // Assign the obtained codec descriptor to our context.
    codecpar = decoder->defaults;
    result = avcodec_parameters_to_context(codec_ctx_video, codecpar);
    if (result < 0) {
        // Handle & log errors
        return 1;
    }

    // ... Other initializations here including open AVPktParser or other demuxers etc.

    // Clean up
    avcodec_free_context(&codec_ctx_video);

    return 0;
}