#include <ApplicationServices/ApplicationServices.h>

void createJPEGWithQuality(CGImageRef image, CFURLRef url, float quality) {
    // Create the image destination
    CGImageDestinationRef destination = CGImageDestinationCreateWithURL(url, kUTTypeJPEG, 1, NULL);
    if (!destination) {
        fprintf(stderr, "Failed to create image destination\n");
        return;
    }

    // Set the options for the image destination
    CFMutableDictionaryRef options = CFDictionaryCreateMutable(NULL, 0, &kCFTypeDictionaryKeyCallBacks, &kCFTypeDictionaryValueCallBacks);
    if (!options) {
        fprintf(stderr, "Failed to create options dictionary\n");
        CFRelease(destination);
        return;
    }

    // Set the compression quality
    CFNumberRef qualityNum = CFNumberCreate(NULL, kCFNumberFloatType, &quality);
    if (qualityNum) {
        CFDictionarySetValue(options, kCGImageDestinationLossyCompressionQuality, qualityNum);
        CFRelease(qualityNum);
    }

    // Add the image to the destination
    CGImageDestinationAddImage(destination, image, options);
    CFRelease(options);

    // Finalize the destination
    if (!CGImageDestinationFinalize(destination)) {
        fprintf(stderr, "Failed to finalize image destination\n");
    }

    // Clean up
    CFRelease(destination);
}

// Example usage
int main() {
    // Assume we have a valid CGImageRef 'image' and CFURLRef 'url'
    // For demonstration purposes, we'll create a dummy image and URL
    CGColorSpaceRef colorSpace = CGColorSpaceCreateWithName(kCGColorSpaceGenericRGB);
    CGContextRef context = CGBitmapContextCreate(NULL, 100, 100, 8, 0, colorSpace, kCGImageAlphaNoneSkipLast);
    CGImageRef image = CGBitmapContextCreateImage(context);
    CFURLRef url = CFURLCreateWithFileSystemPath(NULL, CFSTR("output.jpg"), kCFURLPOSIXPathStyle, false);

    float quality = 0.8f; // Compression quality (0.0 to 1.0)
    createJPEGWithQuality(image, url, quality);

    // Clean up
    CGImageRelease(image);
    CFRelease(url);
    CGContextRelease(context);
    CGColorSpaceRelease(colorSpace);

    return 0;
}