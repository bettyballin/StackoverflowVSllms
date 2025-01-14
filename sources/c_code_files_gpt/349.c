#include <stdint.h>
#include <stdio.h>

// Configuration Descriptor for 100mA (1 unit load)
const uint8_t configDescriptor100mA[] = {
    // Configuration Descriptor
    0x09,                           // bLength
    0x02,                           // bDescriptorType (Configuration)
    0xXX, 0xXX,                     // wTotalLength
    0xXX,                           // bNumInterfaces
    0x01,                           // bConfigurationValue
    0x00,                           // iConfiguration
    0xC0,                           // bmAttributes (Self-powered)
    0x32,                           // bMaxPower (100mA)
    // Other descriptors follow...
};

// Configuration Descriptor for 500mA (5 unit loads)
const uint8_t configDescriptor500mA[] = {
    // Configuration Descriptor
    0x09,                           // bLength
    0x02,                           // bDescriptorType (Configuration)
    0xXX, 0xXX,                     // wTotalLength
    0xXX,                           // bNumInterfaces
    0x02,                           // bConfigurationValue
    0x00,                           // iConfiguration
    0xC0,                           // bmAttributes (Self-powered)
    0xFA,                           // bMaxPower (500mA)
    // Other descriptors follow...
};

int main() {
    printf("Configuration Descriptor for 100mA:\n");
    for (int i = 0; i < sizeof(configDescriptor100mA); i++) {
        printf("%02x ", configDescriptor100mA[i]);
    }
    printf("\n");

    printf("Configuration Descriptor for 500mA:\n");
    for (int i = 0; i < sizeof(configDescriptor500mA); i++) {
        printf("%02x ", configDescriptor500mA[i]);
    }
    printf("\n");

    return 0;
}