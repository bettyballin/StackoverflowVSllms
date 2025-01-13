using SharpPcap;\n\n// Open the default device\nICaptureDevice device = CaptureDeviceList.Instance[0];\ndevice.Open(DeviceMode.Promiscuous);\n\n// Start capturing packets\ndevice.StartCapture();\n\n// Read packets\nwhile (true)\n{\n    Packet packet = device.GetNextPacket();\n    // Process the packet\n}\n\n// Close the device\ndevice.Close();