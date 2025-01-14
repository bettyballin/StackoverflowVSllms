// Note: This code will not compile with GCC for a Windows target without significant modifications.
#include <wdm.h>
#include <wdf.h>
#include <cfgmgr32.h>

// Forward declarations of missing functions
NTSTATUS RegistryEventRemoved(WDFDEVICE, WDFIOTARGET);
NTSTATUS TargetCustomRegChanged(WDFDEVICE, WDFIOTARGET);

WDFDEVICE device; // Assuming device is defined somewhere
WDF_PNPPOWER_EVENT_CALLBACKS pnpPowerCallbacks;

NTSTATUS CreateCustomRegNotify(WDFIOTARGET target) {
    static CM_NOTIFY_FILTER_PARAMS filterParams = { 0 };
    NTSTATUS status;
    // Setup the notification filter
    filterParams.FilterType = CM_NOTIFY_FILTER_TYPE_RESOURCE;
    // Use appropriate type from Cfgmgr32.h for Registry Key notifications
    filterParams.u.ResourceList.Count = 1;
    filterParams.u.ResourceList.ResID[0] = CM_REGISTRY_SOFTWARE_HIVE;
    filterParams.Next = NULL; // No chained filters, just one notification is enough for this case

    // Initialization of parameters needed by the Framework event callback registration function
    WDF_PNPPOWER_EVENT_CALLBACKS_INIT(&pnpPowerCallbacks);

    pnpPowerCallbacks.EvtIoNotifyRemoveDevice = RegistryEventRemoved; // Optional, if you want to be notified about removal of the key as well.

    // Register for notification
    status = WdfDeviceAddNotification(device, &filterParams, TargetCustomRegChanged);  // <--- this is your callback function! Use it to check registry
    return status;
}

// Implement the missing functions
NTSTATUS RegistryEventRemoved(WDFDEVICE Device, WDFIOTARGET target) {
    // Implementation here
    return STATUS_SUCCESS;
}

NTSTATUS TargetCustomRegChanged(WDFDEVICE Device, WDFIOTARGET target) {
    // Implementation here
    return STATUS_SUCCESS;
}

int main() {
    // Example usage:
    WDFIOTARGET target = NULL; // Initialize target appropriately
    CreateCustomRegNotify(target);
    return 0;
}