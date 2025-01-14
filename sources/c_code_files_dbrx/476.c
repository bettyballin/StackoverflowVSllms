#include <CoreServices/CoreServices.h>
#import <IOKit/pwr_mgt/IOPMLibPrivate.h> // for IOReturn_COMPAT macro in case of deprecated API usage
#include <stdio.h>

// Declare a function to handle notifications:
void HandleDiskArbNotification(CFNotificationCenterRef center, void *observer, CFStringRef name, const void *object, CFDictionaryRef userInfo) {
    // Handle the notification
}

int main() {
    // Set up Disk Arbitration Notification:
    DASessionRef session = DASessionCreate(kCFAllocatorDefault);
    if (!session) {
        printf("Failed to create DASession\n");
        return -1;
    }
    int token; // Token to keep track of the added interest request
    CFStringRef name = CFSTR("com.apple.diskarbitration.diskappeared");
    CFNotificationCenterAddObserver(CFNotificationCenterGetDarwinNotifyCenter(), NULL, HandleDiskArbNotification, name, NULL, &token);
    void* ref = CFRetain((CFTypeRef)session); // Add reference and retain the DASession object
    CFRUNLOOPSOURCE_CONVERT_FUNCTION convertFunction = (CFRunLoopSourceConvertFunction)CFFileDescriptorCreateWithNative;
    convertFunction(NULL, &ref, NULL); // Convert the session from a CFType to source handle. Since it's not actually a file descriptor here but just a DASession object, we pass in `NULL` as contextual info.
    ref = CFSwapInt64LittleToHost(*(int64_t *)&ref); // As CFFileDescriptorCreateWithNative uses the lowest 32bits for its flags only; so shift left to get proper pointer value inside source handle object.
    CFRunLoopSourceContext ctx = { .info = ref, .retain = (CFRetainFunction)&CFRetain, .release = (CFReleaseFunction)&CFRelease }; // Create a context using the new source handle. Here retain/release functions are added via static cast of CFRetain and CFRelease.
    CFRunLoopSourceRef darp_source = CFRunLoopSourceCreate(kCFAllocatorDefault, 0 /*flags */ , &ctx); // Instantiate the run loop source object
    CFRunLoopAddSource(CFRunLoopGetMain(), darp_source, kCFRunLoopCommonModes); // Add the run loop source to the default mode of the main loop for processing notifications.
    CFRunLoopRun();
    return 0;
}