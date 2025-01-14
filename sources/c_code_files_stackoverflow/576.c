#include <Windows.h>
#include <Dbt.h>

int main() {
    // Define the device interface GUID. Replace with the specific GUID you are interested in.
    GUID guid = { 0x4d1e55b2, 0xf16f, 0x11cf, { 0x88, 0xcb, 0x00, 0x11, 0x11, 0x00, 0x00, 0x30 } };

    DEV_BROADCAST_DEVICEINTERFACE NotificationFilter;
    DWORD dwSize = sizeof(DEV_BROADCAST_DEVICEINTERFACE);
    NotificationFilter.dbcc_size = dwSize;
    NotificationFilter.dbcc_devicetype = DBT_DEVTYP_DEVICEINTERFACE;
    NotificationFilter.dbcc_reserved = 0;
    NotificationFilter.dbcc_classguid = guid;

    // Register for device notifications
    HDEVNOTIFY hDevNotify = RegisterDeviceNotification(NULL, &NotificationFilter, DEVICE_NOTIFY_WINDOW_HANDLE);
    if (hDevNotify == NULL) {
        // Handle registration failure
        printf("Failed to register for device notifications. Error: %d\n", GetLastError());
        return 1;
    }

    // Message loop to receive notifications
    MSG msg;
    while (GetMessage(&msg, NULL, 0, 0)) {
        // Check if it's a device notification
        if (msg.message == WM_DEVICECHANGE) {
            // Handle device change
            printf("Device change detected!\n");
        }
    }

    // Clean up
    UnregisterDeviceNotification(hDevNotify);

    return 0;
}