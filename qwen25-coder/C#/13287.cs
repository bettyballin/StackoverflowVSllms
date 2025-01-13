using System;\nusing PacketDotNet;\nusing SharpPcap;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        // Get the device list from WinPcap\n        var devices = CaptureDeviceList.Instance;\n\n        if (devices.Count < 1)\n        {\n            Console.WriteLine("No devices were found on this machine");\n            return;\n        }\n\n        // Print out the devices\n        int i = 0;\n        foreach (var device in devices)\n        {\n            ++i;\n            Console.Write("{0}. {1}{2} ({3})",\n                i,\n                device.Description != null ? device.Description : "No description available",\n                device.Loopback ? "[Loopback]" : "",\n                device.PciBusId);\n        }\n\n        int id = 0;\n        do\n        {\n            Console.WriteLine();\n            Console.Write("Enter the number of the device you want to use: ");\n            string s = Console.ReadLine();\n\n            if (s == "q")\n                return;\n\n            // Ensure input is not empty and an integer\n            if (!int.TryParse(s, out id))\n            {\n                id = 0;\n            }\n        } while (id < 1 || id > devices.Count);\n\n        var deviceSelected = devices[id - 1];\n\n        deviceSelected.OnPacketArrival += new PacketArrivalEventHandler(Device_OnPacketArrival);\n        Console.WriteLine();\n        Console.WriteLine("Starting the capture...");\n        deviceSelected.Open(\n            DeviceMode.Promiscuous,\n            100 // read timeout\n        );\n\n        deviceSelected.StartCapture();\n\n        Console.WriteLine("Capturing. Hit 'Enter' to stop.");\n        Console.ReadLine();\n\n        // Stop the capture process\n        deviceSelected.StopCapture();\n\n        // Closedevice opens the device for usage again by other applications.\n        deviceSelected.Close();\n    }\n\n    private static void Device_OnPacketArrival(object sender, PacketArrivalEventArgs e)\n    {\n        var time = e.Timestamp;\n        var length = e.Packet.Length;\n\n        Console.WriteLine("{0} length={1}", time.ToString("yyyy-MM-dd hh:mm:ss.fff"), length);\n        // Ethernet packet?\n        if (e.Packet.LinkLayerType == PacketDotNet.LayerLinkTypes.Ethernet)\n        {\n            var packet = Packet.ParsePacket(e.Packet.LinkLayerType, e.Packet.Data);\n\n            Console.WriteLine(packet.HeaderToString());\n        }\n    }\n}