using System;\nusing PcapDotNet.Core;\n\nclass Program\n{\n    static void Main()\n    {\n        // Retrieve the device list from the local machine\n        IList<LivePacketDevice> allDevices = LivePacketDevice.AllLocalMachine;\n\n        if (allDevices.Count == 0)\n        {\n            Console.WriteLine("No devices were found on this machine!");\n            return;\n        }\n\n        // Print the list\n        for (int i = 0; i != allDevices.Count; i++)\n        {\n            LivePacketDevice device = allDevices[i];\n            Console.Write((i + 1) + ". " + device.Name);\n            if (device.Description != null)\n                Console.WriteLine(" (" + device.Description + ")");\n            else\n                Console.WriteLine(" (No description available)");\n        }\n\n        int deviceIndex = 0;\n        do\n        {\n            Console.Write("\nEnter the number of the device you want to capture: ");\n            string deviceIndexString = Console.ReadLine();\n            if (!int.TryParse(deviceIndexString, out deviceIndex) ||\n                deviceIndex < 1 || deviceIndex > allDevices.Count)\n            {\n                deviceIndex = 0;\n            }\n        } while (deviceIndex == 0);\n\n        PacketDevice selectedDevice = allDevices[deviceIndex - 1];\n\n        // Compile the filter\n        using (PacketCommunicator communicator =\n            selectedDevice.Open(65536,                                  // portion of the packet to capture (64K)\n                               PacketDeviceOpenAttributes.Promiscuous, // promiscuous mode\n                               1000))                                   // read timeout\n        {\n            Console.WriteLine("Listening on " + selectedDevice.Description);\n\n            communicator.ReceivePackets(100, // number of packets to capture (-1 for infinite)\n              packet => Console.WriteLine(packet.Timestamp.ToString("yyyy-MM-dd HH:mm:ss.fff") +\n                                  " length=" + packet.Length));\n        }\n    }\n}