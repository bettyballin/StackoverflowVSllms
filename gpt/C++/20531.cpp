#include <wels/codec_api.h>\n\n   int main() {\n       ISVCDecoder* decoder;\n       SDecodingParam sDecParam = {0};\n       SBufferInfo sDstBufInfo;\n       unsigned char* pData[3] = {NULL};\n       int iRet = WelsCreateDecoder(&decoder);\n\n       if (iRet != 0) {\n           return -1;\n       }\n\n       sDecParam.sVideoProperty.size = sizeof(sDecParam.sVideoProperty);\n       sDecParam.uiTargetDqLayer = UCHAR_MAX;\n       sDecParam.eEcActiveIdc = ERROR_CON_SLICE_COPY;\n       sDecParam.sVideoProperty.eVideoBsType = VIDEO_BITSTREAM_DEFAULT;\n\n       iRet = decoder->Initialize(&sDecParam);\n       if (iRet != 0) {\n           WelsDestroyDecoder(decoder);\n           return -1;\n       }\n\n       // Assuming h264Data is your H.264 encoded data and dataSize is its size\n       unsigned char* h264Data;\n       int dataSize;\n       iRet = decoder->DecodeFrameNoDelay(h264Data, dataSize, pData, &sDstBufInfo);\n       if (iRet == 0 && sDstBufInfo.iBufferStatus == 1) {\n           // Process the decoded frame\n       }\n\n       decoder->Uninitialize();\n       WelsDestroyDecoder(decoder);\n\n       return 0;\n   }