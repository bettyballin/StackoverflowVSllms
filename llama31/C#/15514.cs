using System.Management;\n\npublic class Program\n{\n    public static void Main()\n    {\n        string path = @"\\myserver\users\brian\public\music";\n\n        ManagementObjectSearcher searcher = new ManagementObjectSearcher("SELECT * FROM Win32_Volume WHERE DriveLetter='" + path.Substring(0, 2) + "'");\n\n        foreach (ManagementObject volume in searcher.Get())\n        {\n            Console.WriteLine("Volume Serial Number: " + volume["SerialNumber"]);\n        }\n    }\n}