#include <stdio.h>

const unsigned char wbx_ap[]= { 0x05, 0x04, 0x02, 'W', 'M', 'P'}; // WMP header for access-point bookmark

int main() {
    // You can add code here to use the wbx_ap array
    printf("WBX AP header: ");
    for (int i = 0; i < sizeof(wbx_ap); i++) {
        printf("%02x ", wbx_ap[i]);
    }
    printf("\n");
    return 0;
}