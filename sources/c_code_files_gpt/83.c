#include <turbojpeg.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    // Initialize decompressor
    tjhandle handle = tjInitDecompress();
    if (!handle) {
        fprintf(stderr, "tjInitDecompress() failed\n");
        return -1;
    }

    // Your JPEG data - Make sure to allocate and fill this with your actual JPEG data
    unsigned char *jpegBuf = NULL;  
    unsigned long jpegSize = 0;     

    // Example: Load a JPEG file into jpegBuf
    FILE *jpegFile = fopen("example.jpg", "rb");
    if (jpegFile) {
        fseek(jpegFile, 0, SEEK_END);
        jpegSize = ftell(jpegFile);
        rewind(jpegFile);
        jpegBuf = (unsigned char*)malloc(jpegSize);
        if (jpegBuf) {
            fread(jpegBuf, 1, jpegSize, jpegFile);
        }
        fclose(jpegFile);
    } else {
        fprintf(stderr, "Failed to open example.jpg\n");
        return -1;
    }

    if (!jpegBuf) {
        fprintf(stderr, "Failed to allocate JPEG buffer\n");
        tjDestroy(handle);
        return -1;
    }

    int width, height, jpegSubsamp, jpegColorspace;
    int status = tjDecompressHeader2(handle, jpegBuf, jpegSize, &width, &height, &jpegSubsamp);
    if (status != 0) {
        fprintf(stderr, "tjDecompressHeader2() failed: %d\n", status);
        free(jpegBuf);
        tjDestroy(handle);
        return -1;
    }

    // Allocate buffer for decompressed image
    unsigned char *imgBuf = (unsigned char *)malloc(width * height * tjPixelSize[TJPF_RGB]);
    if (!imgBuf) {
        fprintf(stderr, "Failed to allocate image buffer\n");
        free(jpegBuf);
        tjDestroy(handle);
        return -1;
    }

    // Decompress JPEG
    status = tjDecompress2(handle, jpegBuf, jpegSize, imgBuf, width, 0, height, TJPF_RGB, TJFLAG_FASTDCT);
    if (status != 0) {
        fprintf(stderr, "tjDecompress2() failed: %d\n", status);
    }

    // Cleanup
    tjDestroy(handle);
    free(imgBuf);
    free(jpegBuf);

    return 0;
}