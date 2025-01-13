using System;\nusing System.Management;\n\nclass Program\n{\n    static void Main()\n    {\n        try\n        {\n            ManagementObjectSearcher searcher = new ManagementObjectSearcher("root\\WMI", "SELECT * FROM MSNdis_80211_ServiceSetIdentifier");\n\n            foreach (ManagementObject queryObj in searcher.Get())\n            {\n                byte[] ssid = (byte[])queryObj["Ndis80211SsId"];\n                Console.WriteLine("SSID: " + System.Text.Encoding.ASCII.GetString(ssid));\n            }\n        }\n        catch (ManagementException e)\n        {\n            Console.WriteLine("An error occurred while querying for WMI data: " + e.Message);\n        }\n    }\n}