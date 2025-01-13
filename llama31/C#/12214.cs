using System;\nusing System.Management;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        string remoteMachine = "your_remote_machine_name";\n        string query = "SELECT PercentProcessorTime FROM Win32_PerfRawData_PerfOS_Processor WHERE Name='_Total'";\n\n        ManagementObjectSearcher searcher = new ManagementObjectSearcher(\n            new ManagementScope($"\\\\{remoteMachine}\\root\\cimv2"), \n            new ObjectQuery(query));\n\n        foreach (ManagementObject item in searcher.Get())\n        {\n            Console.WriteLine($"CPU Usage: {item["PercentProcessorTime"]}%");\n        }\n    }\n}