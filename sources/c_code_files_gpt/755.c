#include <turbojpeg.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    tjhandle handle = tjInitCompress();
    unsigned char *jpegBuf = NULL; // Buffer for compressed image
    unsigned long jpegSize = 0; // Size of the compressed image
    int width = 640, height = 480; // Example resolution
    int jpegSubsamp = TJSAMP_444; // No subsampling
    int jpegQual = 50; // Lower quality for lower CPU usage

    unsigned char *imgBuf = (unsigned char *)malloc(width * height * 3); // Example raw image data

    if (tjCompress2(handle, imgBuf, width, 0, height, TJPF_RGB, &jpegBuf, &jpegSize, jpegSubsamp, jpegQual, TJFLAG_FASTDCT) < 0) {
        printf("Error during JPEG compression: %s\n", tjGetErrorStr());
        tjDestroy(handle);
        return -1;
    }

    // Free allocated memory
    tjFree(jpegBuf);
    free(imgBuf);
    tjDestroy(handle);

    return 0;
}