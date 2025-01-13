using System;\nusing System.Management;\n\nclass Program\n{\n    static void Main()\n    {\n        try\n        {\n            // Create a ManagementObjectSearcher to query system information\n            ManagementObjectSearcher searcher = new ManagementObjectSearcher("SELECT * FROM Win32_PnPEntity");\n\n            // Execute the query and get the results\n            foreach (ManagementObject obj in searcher.Get())\n            {\n                Console.WriteLine("Device Name: " + obj["Name"]);\n                Console.WriteLine("Device ID: " + obj["DeviceID"]);\n                Console.WriteLine("PNP Device ID: " + obj["PNPDeviceID"]);\n                Console.WriteLine("Description: " + obj["Description"]);\n                Console.WriteLine();\n            }\n        }\n        catch (Exception e)\n        {\n            Console.WriteLine("An error occurred while querying hardware information: " + e.Message);\n        }\n    }\n}