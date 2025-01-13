using System;\nusing System.Diagnostics;\nusing System.Text.RegularExpressions;\n\npublic class ArpHelper\n{\n    public static void GetArpTable()\n    {\n        // Start the process to run the 'arp -a' command\n        ProcessStartInfo startInfo = new ProcessStartInfo("arp")\n        {\n            Arguments = "-a",\n            RedirectStandardOutput = true,\n            UseShellExecute = false,\n            CreateNoWindow = true\n        };\n        \n        // Execute the process and read the output\n        using (Process process = Process.Start(startInfo))\n        {\n            using (System.IO.StreamReader reader = process.StandardOutput)\n            {\n                string output = reader.ReadToEnd();\n                ParseArpTable(output);\n            }\n        }\n    }\n\n    private static void ParseArpTable(string arpTable)\n    {\n        // Regular expression to match ARP table entries\n        Regex regex = new Regex(@"(?<IP>\d+\.\d+\.\d+\.\d+)\s+(?<MAC>([0-9A-Fa-f]{2}-){5}[0-9A-Fa-f]{2})\s+(?<Type>\w+)");\n        MatchCollection matches = regex.Matches(arpTable);\n\n        // Loop through the matches and print the IP and MAC addresses\n        foreach (Match match in matches)\n        {\n            string ip = match.Groups["IP"].Value;\n            string mac = match.Groups["MAC"].Value;\n            string type = match.Groups["Type"].Value;\n\n            Console.WriteLine($"IP Address: {ip}, MAC Address: {mac}, Type: {type}");\n        }\n    }\n\n    public static void Main()\n    {\n        GetArpTable();\n    }\n}