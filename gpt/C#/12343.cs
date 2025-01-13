public static ArrayList GetEthernetMacAddresses()\n{\n    ArrayList addresses = new ArrayList();\n    ManagementClass mgmt = new ManagementClass("Win32_NetworkAdapterConfiguration");\n    ManagementObjectCollection objCol = mgmt.GetInstances();\n\n    foreach (ManagementObject obj in objCol)\n    {\n        if ((bool)obj["IPEnabled"])\n        {\n            string macAddr = obj["MACAddress"] as string;\n            string adapterType = obj["Description"] as string;\n\n            if (!String.IsNullOrEmpty(macAddr) && !String.IsNullOrEmpty(adapterType))\n            {\n                if (adapterType.StartsWith("Ethernet"))\n                {\n                    addresses.Add(macAddr);\n                }\n            }\n        }\n        obj.Dispose();\n    }\n    return addresses;\n}