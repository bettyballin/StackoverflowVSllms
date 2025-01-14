#include <stdio.h>
#include <stdlib.h>
#include <nfc/nfc.h>

// Define the read command
uint8_t read_command[] = { 0x30, 0x00 };

void read_nfc_tag() {
    nfc_context *context;
    nfc_device *device;
    nfc_target target;
    uint8_t buffer[256];
    int res;

    nfc_init(&context);
    if (context == NULL) {
        printf("Unable to init libnfc\n");
        return;
    }

    device = nfc_open(context, NULL);
    if (device == NULL) {
        printf("Unable to open NFC device\n");
        nfc_exit(context);
        return;
    }

    if (nfc_initiator_init(device) < 0) {
        printf("NFC initiator init failed\n");
        nfc_close(device);
        nfc_exit(context);
        return;
    }

    if (nfc_initiator_select_passive_target(device, nm_mifare, NULL, 0, &target) > 0) {
        res = nfc_initiator_transceive_bytes(device, read_command, sizeof(read_command), buffer, sizeof(buffer), 0);
        if (res > 0) {
            printf("Data read from NFC tag: %s\n", buffer);
        } else {
            printf("Failed to read from NFC tag\n");
        }
    }

    nfc_close(device);
    nfc_exit(context);
}

int main() {
    read_nfc_tag();
    return 0;
}