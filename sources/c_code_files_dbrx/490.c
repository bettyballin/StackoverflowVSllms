#include <CoreFoundation/CoreFoundation.h>
#include <DiskArbitration/DiskArbitration.h>

void HandleDiskArbNotification(CFNotificationCenterRef center, void *observer, CFStringRef name, const void *object, CFDictionaryRef userInfo) {
    // The object parameter contains a reference to the DADisk object which triggered this event. You can use it to retrieve information about the disk or volume with functions like `DARegisterDiskAppearedCallback` and `DADiskGetDescription`.
}

int main() {
    // Register the notification callback
    CFNotificationCenterAddObserver(CFNotificationCenterGetDarwinNotifyCenter(), NULL, HandleDiskArbNotification, CFSTR("com.apple.diskarbitration.diskappeared"), NULL, CFNotificationSuspensionBehaviorDeliverImmediately);

    // Run the run loop to receive notifications
    CFRunLoopRun();

    return 0;
}