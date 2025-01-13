using System.Management;\n\nclass NetworkController\n{\n\n    public static void Disable()\n    {\n        SetIP("192.168.0.4", "255.255.255.0");\n    }\n\n    public static void Enable()\n    {\n        SetDHCP();\n    }\n\n\n    private static void SetIP(string ip_address, string subnet_mask)\n    {\n        ManagementClass objMC = new ManagementClass("Win32_NetworkAdapterConfiguration");\n        ManagementObjectCollection objMOC = objMC.GetInstances();\n\n        foreach (ManagementObject objMO in objMOC) {\n            if ((bool)objMO("IPEnabled")) {\n                try {\n                    ManagementBaseObject setIP = default(ManagementBaseObject);\n                    ManagementBaseObject newIP = objMO.GetMethodParameters("EnableStatic");\n\n                    newIP("IPAddress") = new string[] { ip_address };\n                    newIP("SubnetMask") = new string[] { subnet_mask };\n\n                    setIP = objMO.InvokeMethod("EnableStatic", newIP, null);\n                }\n                catch (Exception generatedExceptionName) {\n                    throw;\n                }\n            }\n\n\n        }\n    }\n\n    private static void SetDHCP()\n    {\n        ManagementClass mc = new ManagementClass("Win32_NetworkAdapterConfiguration");\n        ManagementObjectCollection moc = mc.GetInstances();\n\n        foreach (ManagementObject mo in moc) {\n            // Make sure this is a IP enabled device. Not something like memory card or VM Ware\n            if ((bool)mo("IPEnabled")) {\n                ManagementBaseObject newDNS = mo.GetMethodParameters("SetDNSServerSearchOrder");\n                newDNS("DNSServerSearchOrder") = null;\n                ManagementBaseObject enableDHCP = mo.InvokeMethod("EnableDHCP", null, null);\n                ManagementBaseObject setDNS = mo.InvokeMethod("SetDNSServerSearchOrder", newDNS, null);\n            }\n        }\n    }\n}