#ifdef _WIN32
#include <windows.h>
#endif
#include <stdio.h>

#ifdef _WIN32
void GetTimeZoneIdentifier() {
    TIME_ZONE_INFORMATION tzInfo;
    DWORD result = GetTimeZoneInformation(&tzInfo);

    if (result == TIME_ZONE_ID_UNKNOWN || result == TIME_ZONE_ID_STANDARD || result == TIME_ZONE_ID_DAYLIGHT) {
        wprintf(L"Time Zone Standard Name: %s\n", tzInfo.StandardName);
    } else {
        wprintf(L"Failed to get time zone information.\n");
    }
}
#endif

int main() {
    #ifdef _WIN32
    GetTimeZoneIdentifier();
    #else
    printf("This program requires Windows-specific APIs and cannot run on this platform.\n");
    #endif
    return 0;
}