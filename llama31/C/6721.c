// USB Configuration Descriptor\ntypedef struct {\n    uint8_t bLength;               // Descriptor length\n    uint8_t bDescriptorType;       // Descriptor type (Configuration)\n    uint16_t wTotalLength;         // Total length of the configuration descriptor\n    uint8_t bNumInterfaces;        // Number of interfaces\n    uint8_t bConfigurationValue;   // Configuration value\n    uint8_t iConfiguration;        // Index of the configuration string\n    uint8_t bmAttributes;          // Attributes (bus-powered, self-powered, etc.)\n    uint8_t bMaxPower;             // Maximum power consumption (in units of 2mA)\n} __attribute__((packed)) usb_config_descriptor_t;\n\n// ...\n\nusb_config_descriptor_t config_descriptor = {\n    .bLength = sizeof(usb_config_descriptor_t),\n    .bDescriptorType = USB_DESC_TYPE_CONFIG,\n    .wTotalLength = sizeof(usb_config_descriptor_t),\n    .bNumInterfaces = 1,\n    .bConfigurationValue = 1,\n    .iConfiguration = 0,\n    .bmAttributes = USB_CONFIG_BUS_POWERED,\n    .bMaxPower = 250, // 500mA / 2mA = 250\n};