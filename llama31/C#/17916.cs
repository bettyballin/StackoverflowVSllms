using System;\nusing System.Management;\n\nclass UsbDeviceWatcher\n{\n    private ManagementEventWatcher _watcher;\n\n    public UsbDeviceWatcher()\n    {\n        _watcher = new ManagementEventWatcher();\n        _watcher.Query = "SELECT * FROM Win32_USBHub WHERE DeviceID='USBSTOR'";\n        _watcher.EventArrived += new EventArrivedEventHandler(DeviceArrived);\n        _watcher.Start();\n    }\n\n    private void DeviceArrived(object sender, EventArrivedEventArgs e)\n    {\n        Console.WriteLine("USB device plugged in!");\n        // Get device details\n        var device = (ManagementBaseObject)e.NewEvent;\n        Console.WriteLine("Device ID: " + device["DeviceID"]);\n        Console.WriteLine("PNP Device ID: " + device["PNPDeviceID"]);\n    }\n\n    public void Stop()\n    {\n        _watcher.Stop();\n    }\n}