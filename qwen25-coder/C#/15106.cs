using System;\nusing PacketDotNet;\nusing SharpPcap;\n\nclass Program\n{\n    static void Main()\n    {\n        // Print out the devices available on this machine.\n        Console.WriteLine("The following devices are available on this machine:");\n        int i = 0;\n\n        foreach (ICaptureDevice dev in CaptureDeviceList.Instance)\n        {\n            string description = (dev.Description != null) ? dev.Description : "No description available";\n            Console.WriteLine("{0}) {1} {2}", i, dev.Name, description);\n            i++;\n        }\n\n        // Ask the user which device to use\n        Console.Write("Enter the number of the device you would like to open: ");\n        string deviceIndexString = Console.ReadLine();\n        int deviceIndex;\n        if (!int.TryParse(deviceIndexString, out deviceIndex) ||\n         deviceIndex < 0 || deviceIndex >= CaptureDeviceList.Instance.Count)\n        {\n            Console.WriteLine("Invalid device index");\n            return;\n        }\n\n        // Open the selected device\n        ICaptureDevice devices = CaptureDeviceList.Instance[deviceIndex];\n        int readTimeoutMilliseconds = 1000;    // Read timeout in milliseconds\n        devices.Open(DeviceMode.Promiscuous, readTimeoutMilliseconds);\n\n        // Use a buffer large enough to capture our data quickly and \n        // without packet drops on most systems\n        int maxSizeInBytes = 65536;\n        devices.OnPacketArrival += new Packet ArrivalEventHandler(device_OnPacketArrival);\n        devices.StartCapture();\n        \n        Console.WriteLine("Listening for packets...");\n        Console.ReadLine(); // Wait until the user decides to exit\n\n        devices.StopCapture();\n        devices.Close();\n    }\n\n    private static void device_OnPacketArrival(object sender, CaptureEventArgs e)\n    {\n        Console.WriteLine("Received packet at " + DateTime.Now);\n\n        var rawP = e.Packet;\n        string timeString =\n            "{" +\n            rawP.Timeval.Date.Year + "-" +\n            rawP.Timeval.Date.Month + "-" +\n            rawP.Timeval.Date.Day + " " +\n            rawP.Timeval.Date.Hour + ":" +\n            rawP.Timeval.Date.Minute + ":" +\n            rawP.Timeval.Date.Second + "." +\n            (rawP.Timeval.Milliseconds).ToString("X").PadLeft(3, '0') +\n            "}";\n\n        Console.WriteLine("{0}:{1} length={2}", timeString,\n                            rawP.Header.Timestamp.Seconds,\n                            rawP.TotalLength);\n    }\n}