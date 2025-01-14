#include <SystemConfiguration/SystemConfiguration.h>

int main() {
    CFStringRef result = SCDynamicStoreCopyConsoleUser(NULL, NULL, NULL);
    // You may want to use the result here, for example:
    // printf("%s\n", CFStringGetCStringPtr(result, kCFStringEncodingUTF8));
    // Don't forget to release the result if you're not using ARC
    // CFRelease(result);
    return 0;
}