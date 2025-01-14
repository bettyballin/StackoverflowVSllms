#include <Security/Security.h>
#include <CoreFoundation/CoreFoundation.h>

int main() {
    // Define the ciphers you want to add, for example:
    SSLCipherSuite ciphers[] = {
        TLS_RSA_WITH_AES_128_GCM_SHA256,
        TLS_RSA_WITH_AES_256_GCM_SHA384,
        TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
        TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384
    };

    // Create a CFNumber array from the ciphers
    CFNumberRef cipherNumbers[sizeof(ciphers) / sizeof(ciphers[0])];
    for (int i = 0; i < sizeof(ciphers) / sizeof(ciphers[0]); i++) {
        cipherNumbers[i] = CFNumberCreate(kCFAllocatorDefault, kCFNumberSInt32Type, &ciphers[i]);
    }

    // Create a CFArray with the cipher numbers
    CFArrayRef ciphersArray = CFArrayCreate(kCFAllocatorDefault, (const void **)cipherNumbers, sizeof(ciphers) / sizeof(ciphers[0]), &kCFTypeArrayCallBacks);

    // Release the CFNumbers now that they are in the array
    for (int i = 0; i < sizeof(ciphers) / sizeof(ciphers[0]); i++) {
        CFRelease(cipherNumbers[i]);
    }

    // Set up the SSL settings dictionary
    const void *keys[] = { kCFStreamSSLLevel, kCFStreamSSLAllowsExpiredCertificates, kCFStreamSSLAllowsExpiredRoots, kCFStreamSSLAllowsAnyRoot, kCFStreamSSLValidatesCertificateChain, kCFStreamSSLPeerName, kCFStreamSSLAllowedCiphers };
    const void *values[] = { kCFStreamSocketSecurityLevelNegotiatedSSL, kCFBooleanFalse, kCFBooleanFalse, kCFBooleanFalse, kCFBooleanTrue, kCFNull, ciphersArray };

    CFDictionaryRef sslSettings = CFDictionaryCreate(kCFAllocatorDefault, keys, values, sizeof(keys) / sizeof(keys[0]), &kCFTypeDictionaryKeyCallBacks, &kCFTypeDictionaryValueCallBacks);

    // Create a CFReadStream (you'll need to replace this with your actual read stream)
    CFReadStreamRef theReadStream = NULL; // Replace with your actual read stream

    // Apply the SSL settings to the read stream
    CFReadStreamSetProperty(theReadStream, kCFStreamPropertySSLSettings, sslSettings);

    // Release the created objects
    CFRelease(ciphersArray);
    CFRelease(sslSettings);

    return 0;
}