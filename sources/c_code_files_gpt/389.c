#include <CoreFoundation/CoreFoundation.h>
#include <SystemConfiguration/SystemConfiguration.h>
#include <stdio.h>
#include <unistd.h>

int main() {
    CFStringRef consoleUser;
    uid_t uid;
    gid_t gid;

    consoleUser = SCDynamicStoreCopyConsoleUser(NULL, &uid, &gid);

    if (consoleUser) {
        printf("Console User: %s\n", CFStringGetCStringPtr(consoleUser, kCFStringEncodingUTF8));
        printf("User ID: %d\n", uid);
        CFRelease(consoleUser);
    } else {
        printf("No console user.\n");
    }

    return 0;
}