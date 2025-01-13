using System;\nusing System.Runtime.InteropServices;\n\n// Import the NATUPnP COM library\n[ComImport]\n[Guid("3323DFA8-1CE1-49F9-AE64-1D7F9F5E4A9D")]\ninterface INATExternalIPAddressCallback\n{\n    void NewExternalIPAddress([MarshalAs(UnmanagedType.BStr)] string bstrNewExternalIPAddress);\n}\n\nclass Program\n{\n    [STAThread]\n    static void Main(string[] args)\n    {\n        // Create an instance of the NATUPnP library\n        Type natType = Type.GetTypeFromProgID("NATUPnP.NATUPnP");\n        object nat = Activator.CreateInstance(natType);\n\n        // Get the external IP address\n        INATExternalIPAddressCallback callback = new NATExternalIPAddressCallback();\n        natType.InvokeMember("GetExternalIPAddress", BindingFlags.InvokeMethod, null, nat, new object[] { callback });\n\n        // Wait for the callback to be invoked\n        while (callback.ExternalIPAddress == null)\n        {\n            Thread.Sleep(100);\n        }\n\n        Console.WriteLine("External IP Address: " + callback.ExternalIPAddress);\n    }\n}\n\nclass NATExternalIPAddressCallback : INATExternalIPAddressCallback\n{\n    public string ExternalIPAddress { get; private set; }\n\n    public void NewExternalIPAddress(string bstrNewExternalIPAddress)\n    {\n        ExternalIPAddress = bstrNewExternalIPAddress;\n    }\n}