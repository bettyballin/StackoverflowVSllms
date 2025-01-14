#include <CoreFoundation/CoreFoundation.h>
#include <Security/Security.h>

int main() {
    // Assuming you have an initialized CFReadStreamRef named readStream
    CFReadStreamRef readStream = NULL; // Initialize readStream here

    SSLContextRef sslContext = NULL;
    CFTypeRef sslContextProperty = CFReadStreamCopyProperty(readStream, kCFStreamPropertySSLContext);

    if (sslContextProperty && CFGetTypeID(sslContextProperty) == SSLContextGetTypeID()) {
        sslContext = (SSLContextRef)sslContextProperty;
    }

    // Don't forget to release the property after using it
    if (sslContextProperty) {
        CFRelease(sslContextProperty);
    }

    // Now you can use the sslContext with SecureTransport functions
    if (sslContext) {
        // Example: Retrieve enabled ciphers
        size_t numCiphers;
        SSLCipherSuite *ciphers;
        OSStatus status = SSLGetEnabledCiphers(sslContext, &ciphers, &numCiphers);
        if (status == noErr) {
            // Process the ciphers
        }
    }

    return 0;
}