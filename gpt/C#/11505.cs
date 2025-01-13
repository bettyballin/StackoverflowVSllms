using System;\nusing NativeWifi;\n\nclass Program\n{\n    static void Main()\n    {\n        try\n        {\n            WlanClient client = new WlanClient();\n            foreach (WlanClient.WlanInterface wlanIface in client.Interfaces)\n            {\n                // Get the SSID of the connected network\n                Wlan.Dot11Ssid ssid = wlanIface.CurrentConnection.wlanAssociationAttributes.dot11Ssid;\n                string ssidString = new string((char[])ssid.SSID, 0, (int)ssid.SSIDLength);\n                Console.WriteLine("Connected to SSID: " + ssidString);\n            }\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine("An error occurred: " + ex.Message);\n        }\n    }\n}