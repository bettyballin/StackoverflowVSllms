#include <libavformat/avformat.h>

int main() {
    AVFormatContext* ifmt_ctx = NULL;
    AVFormatContext* ofmt_ctx = NULL; // assuming this is declared elsewhere in the code
    AVStream* video_stream = NULL, *audio_stream = NULL;
    const char* filename = "your_filename.avi"; // replace with your actual filename
    int ret;
    int i;

    if ((ret = avformat_open_input(&ifmt_ctx, filename, NULL, NULL)) < 0) {
        // handle error and return/exit
        fprintf(stderr, "Error opening input file: %s\n", av_err2str(ret));
        return 1;
    }

    // assuming ofmt_ctx is initialized elsewhere in the code

    for (i = 0; i < ifmt_ctx->nb_streams; i++) {
        // Get info about input format
        avcodec_parameters_copy(ofmt_ctx->streams[i]->codecpar, ifmt_ctx->streams[i]->codecpar);
        if (ifmt_ctx->streams[i]->codecpar->codec_id == AV_CODEC_ID_H264) { /* If it's H.264 video stream */
            // Process using the decoder
            printf("H.264 video stream found\n");
        } else {
            // other codecs
            printf("Non-H.264 stream found\n");
        }
    }

    avformat_close_input(&ifmt_ctx);
    return 0;
}