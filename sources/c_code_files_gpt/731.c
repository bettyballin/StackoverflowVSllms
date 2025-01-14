#include <libavcodec/avcodec.h>
#include <libavformat/avformat.h>
#include <libswscale/swscale.h>

int main(int argc, char *argv[]) {
    AVFormatContext *pFormatCtx = NULL;
    int videoStream, frameFinished;
    AVCodecContext *pCodecCtx = NULL;
    AVCodec *pCodec = NULL;
    AVFrame *pFrame = NULL;
    AVPacket packet;
    struct SwsContext *sws_ctx = NULL;

    av_register_all();

    if (avformat_open_input(&pFormatCtx, argv[1], NULL, NULL) != 0)
        return -1;

    if (avformat_find_stream_info(pFormatCtx, NULL) < 0)
        return -1;

    av_dump_format(pFormatCtx, 0, argv[1], 0);

    videoStream = -1;
    for (int i = 0; i < pFormatCtx->nb_streams; i++)
        if (pFormatCtx->streams[i]->codecpar->codec_type == AVMEDIA_TYPE_VIDEO) {
            videoStream = i;
            break;
        }

    if (videoStream == -1)
        return -1;

    pCodecCtx = avcodec_alloc_context3(NULL);
    avcodec_parameters_to_context(pCodecCtx, pFormatCtx->streams[videoStream]->codecpar);

    pCodec = avcodec_find_decoder(pCodecCtx->codec_id);
    if (pCodec == NULL)
        return -1;

    if (avcodec_open2(pCodecCtx, pCodec, NULL) < 0)
        return -1;

    pFrame = av_frame_alloc();

    while (av_read_frame(pFormatCtx, &packet) >= 0) {
        if (packet.stream_index == videoStream) {
            avcodec_send_packet(pCodecCtx, &packet);
            frameFinished = avcodec_receive_frame(pCodecCtx, pFrame);
            if (frameFinished == 0) {
                // Process the decoded frame
            }
        }
        av_packet_unref(&packet);
    }

    av_frame_free(&pFrame);
    avcodec_free_context(&pCodecCtx);
    avformat_close_input(&pFormatCtx);

    return 0;
}