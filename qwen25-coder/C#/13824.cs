using System;\nusing LibUsbDotNet;\nusing LibUsbDotNet.Main;\n\nclass Program\n{\n    static void Main()\n    {\n        // Get all devices connected via USB.\n        UsbDevice.AllDevices.ForEach(device =>\n        {\n            Console.WriteLine($"VID: {device.Info.Descriptor.Vid}, PID: {device.Info.Descriptor.Pid}");\n            \n            // Replace with your printer's Vendor ID and Product ID\n            if (device.Info.Descriptor.Vid == 0x04B8 && device.Info.Descriptor.Pid == 0x0202)\n            {\n                Console.WriteLine("Found Printer!");\n                \n                // Open the USB device.\n                UsbDevice usbDevice;\n                ErrorCode errorCode = device.Open(out usbDevice);\n\n                if (errorCode != ErrorCode.None) throw new Exception(errorCode.ToString());\n\n                try\n                {\n                    // Setup a communication channel for writing data to the printer.\n                    IUsbEndpointWriter writer = usbDevice.OpenEndpointWriter(WriteEndpointID.Ep01);\n                    \n                    // Send some data to the printer as example. Adapt this according to your printer protocol.\n                    byte[] sendData = { 27, 64 }; // Reset command for some printers (ESC @)\n                    errorCode = writer.Write(sendData, out int bytesWritten);\n\n                    if (errorCode != ErrorCode.None) throw new Exception(errorCode.ToString());\n\n                    Console.WriteLine($"{bytesWritten} bytes sent to printer successfully.");\n                }\n                catch (Exception ex)\n                {\n                    Console.WriteLine($"Error: {ex.Message}");\n                }\n                finally\n                {\n                    usbDevice.Close();\n                }\n            }\n        });\n    }\n}