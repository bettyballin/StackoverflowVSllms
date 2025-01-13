using System;\nusing System.Management;\nusing System.Drawing.Printing;\n\nclass Program\n{\n    static void Main()\n    {\n        string defaultPrinterName = PrinterSettings.InstalledPrinters.Cast<string>().FirstOrDefault(p => p == PrinterSettings.InstalledPrinters[0]);\n        \n        Console.WriteLine("Default Printer Name: " + defaultPrinterName);\n        Console.WriteLine("Network Path: " + GetNetworkPath(defaultPrinterName));\n    }\n\n    static string GetNetworkPath(string printerName)\n    {\n        string networkPath = "";\n        try\n        {\n            using (ManagementObjectSearcher searcher = new ManagementObjectSearcher("SELECT * FROM Win32_Printer WHERE Name='" + printerName.Replace(@"\", @"\\") + "'"))\n            {\n                foreach (ManagementObject printerObj in searcher.Get())\n                {\n                    networkPath = printerObj["PortName"]?.ToString();\n                    break;\n                }\n            }\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine("An error occurred: " + ex.Message);\n        }\n        return networkPath;\n    }\n}