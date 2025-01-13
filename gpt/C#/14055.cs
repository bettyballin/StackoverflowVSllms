using System;\nusing System.Management;\n\nclass Program\n{\n    static void Main()\n    {\n        try\n        {\n            ManagementObjectSearcher searcher = new ManagementObjectSearcher(@"root\SecurityCenter2", "SELECT * FROM AntiVirusProduct");\n\n            foreach (ManagementObject queryObj in searcher.Get())\n            {\n                Console.WriteLine("DisplayName: {0}", queryObj["displayName"]);\n                Console.WriteLine("InstanceGuid: {0}", queryObj["instanceGuid"]);\n                Console.WriteLine("PathToExe: {0}", queryObj["pathToExe"]);\n                Console.WriteLine("ProductState: {0}", queryObj["productState"]);\n            }\n        }\n        catch (ManagementException e)\n        {\n            Console.WriteLine("An error occurred while querying for WMI data: " + e.Message);\n        }\n    }\n}