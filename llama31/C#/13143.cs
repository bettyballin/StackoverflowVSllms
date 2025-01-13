using LibUsbDotNet;\nusing LibUsbDotNet.Info;\n\nclass UsbPrinter\n{\n    public void Print(string printerName, byte[] data)\n    {\n        UsbDeviceFinder finder = new UsbDeviceFinder(0x03EB, 0x6124); // replace with your printer's VID and PID\n        UsbDevice device = UsbDevice.OpenUsbDevice(finder);\n        if (device != null)\n        {\n            device.Write(data);\n            device.Close();\n        }\n        else\n        {\n            Console.WriteLine("Error opening printer");\n        }\n    }\n}