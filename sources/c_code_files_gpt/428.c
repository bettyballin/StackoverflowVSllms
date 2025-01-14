#include <DiskArbitration/DiskArbitration.h>
#include <CoreFoundation/CoreFoundation.h>

void diskAppeared(DADiskRef disk, void *context) {
    CFDictionaryRef desc = DADiskCopyDescription(disk);
    if (desc) {
        CFShow(desc);
        CFRelease(desc);
    }
}

void diskDisappeared(DADiskRef disk, void *context) {
    CFDictionaryRef desc = DADiskCopyDescription(disk);
    if (desc) {
        CFShow(desc);
        CFRelease(desc);
    }
}

int main() {
    DASessionRef session = DASessionCreate(kCFAllocatorDefault);
    if (!session) {
        return 1;
    }

    DARegisterDiskAppearedCallback(session, NULL, diskAppeared, NULL);
    DARegisterDiskDisappearedCallback(session, NULL, diskDisappeared, NULL);

    CFRunLoopRun();
    
    CFRelease(session);
    return 0;
}