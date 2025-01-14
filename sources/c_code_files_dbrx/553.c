#include <stdio.h>
#include <turbojpeg.h>

int main() {
    // Your input image data
    unsigned char *image = NULL; // Replace with your image data
    int width = 0, height = 0; // Replace with your image dimensions
    int jpegWidth = 0, jpegHeight = 0; // Replace with your desired JPEG dimensions

    // Create compressor instance
    tjhandle tjInstance = tjInitCompress();

    // Buffer for compressed data
    unsigned char *imageBuffer = NULL;
    size_t imageSize = 0;

    // Set flags and quality
    int flags = TJFLAG_PROGRESSIVE; // or whatever flags you want to set (see docs)
    int quality = 80; // Replace with your desired quality (1-100)
    int subsamp = TJSAMP_411; // Replace with your desired subsampling (see docs)

    // Perform encoding
    tjCompress2(tjInstance, image, width, 0, height, 
                jpegWidth, jpegHeight, TJPF_RGBX, &imageBuffer, 
                &imageSize, flags, quality, subsamp);

    // Free compressor instance
    tjDestroy(tjInstance);

    return 0;
}