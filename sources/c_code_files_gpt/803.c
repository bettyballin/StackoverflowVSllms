#include <nfc/nfc.h>
#include <stdio.h>
#include <stdlib.h>

void list_devices() {
    nfc_context *context;
    nfc_device **devices;
    size_t device_count;

    nfc_init(&context);
    if (context == NULL) {
        printf("Unable to init libnfc\n");
        return;
    }

    device_count = nfc_list_devices(context, NULL, 0);
    devices = malloc(device_count * sizeof(nfc_device *));
    device_count = nfc_list_devices(context, devices, device_count);

    for (size_t i = 0; i < device_count; i++) {
        printf("NFC device: %s\n", nfc_device_get_name(devices[i]));
    }

    nfc_exit(context);
    free(devices);
}

int main() {
    list_devices();
    return 0;
}