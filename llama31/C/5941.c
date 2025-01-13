// libavcodec example\n#include <libavcodec/avcodec.h>\n\nint main() {\n    // Initialize decoder\n    AVCodec* codec = avcodec_find_decoder(AV_CODEC_ID_H264);\n    AVCodecContext* ctx = avcodec_alloc_context3(codec);\n\n    // Decode frame\n    uint8_t* frame = ...; // frame data\n    int frame_size = ...; // frame size\n    avcodec_decode_video2(ctx, frame, frame_size);\n\n    // Release decoder\n    avcodec_free_context(&ctx);\n    return 0;\n}