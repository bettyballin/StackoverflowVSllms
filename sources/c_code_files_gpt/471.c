#include <turbojpeg.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    const int width = 800;
    const int height = 600;
    const int quality = 85;
    unsigned char *jpegBuf = NULL;
    unsigned long jpegSize = 0;

    // Create a dummy image (RGB)
    unsigned char *imgBuf = malloc(width * height * 3);
    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            imgBuf[(y * width + x) * 3 + 0] = x % 256; // Red
            imgBuf[(y * width + x) * 3 + 1] = y % 256; // Green
            imgBuf[(y * width + x) * 3 + 2] = (x + y) % 256; // Blue
        }
    }

    tjhandle tjInstance = tjInitCompress();
    if (tjCompress2(tjInstance, imgBuf, width, 0, height, TJPF_RGB, &jpegBuf, &jpegSize, TJSAMP_444, quality, TJFLAG_FASTDCT) < 0) {
        fprintf(stderr, "Failed to compress image: %s\n", tjGetErrorStr());
        tjDestroy(tjInstance);
        free(imgBuf);
        return 1;
    }

    FILE *jpegFile = fopen("output.jpg", "wb");
    if (jpegFile == NULL) {
        perror("Failed to open output file");
        tjFree(jpegBuf);
        tjDestroy(tjInstance);
        free(imgBuf);
        return 1;
    }

    fwrite(jpegBuf, sizeof(unsigned char), jpegSize, jpegFile);
    fclose(jpegFile);

    tjFree(jpegBuf);
    tjDestroy(tjInstance);
    free(imgBuf);

    return 0;
}