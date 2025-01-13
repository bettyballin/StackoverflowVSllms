using System;\nusing System.Management;\nusing System.Security.Cryptography;\nusing System.Text;\n\npublic class HardwareId\n{\n    public static string GetHardwareId()\n    {\n        string cpuId = GetCpuId();\n        string biosId = GetBiosId();\n        string diskId = GetDiskId();\n\n        string combinedId = cpuId + biosId + diskId;\n        return ComputeSha256Hash(combinedId);\n    }\n\n    private static string GetCpuId()\n    {\n        string cpuId = "";\n        ManagementObjectSearcher mos = new ManagementObjectSearcher("select ProcessorId from Win32_Processor");\n        foreach (ManagementObject mo in mos.Get())\n        {\n            cpuId = mo["ProcessorId"].ToString();\n            break;\n        }\n        return cpuId;\n    }\n\n    private static string GetBiosId()\n    {\n        string biosId = "";\n        ManagementObjectSearcher mos = new ManagementObjectSearcher("select SerialNumber from Win32_BIOS");\n        foreach (ManagementObject mo in mos.Get())\n        {\n            biosId = mo["SerialNumber"].ToString();\n            break;\n        }\n        return biosId;\n    }\n\n    private static string GetDiskId()\n    {\n        string diskId = "";\n        ManagementObjectSearcher mos = new ManagementObjectSearcher("select SerialNumber from Win32_DiskDrive");\n        foreach (ManagementObject mo in mos.Get())\n        {\n            diskId = mo["SerialNumber"].ToString();\n            break;\n        }\n        return diskId;\n    }\n\n    private static string ComputeSha256Hash(string rawData)\n    {\n        using (SHA256 sha256Hash = SHA256.Create())\n        {\n            byte[] bytes = sha256Hash.ComputeHash(Encoding.UTF8.GetBytes(rawData));\n\n            StringBuilder builder = new StringBuilder();\n            for (int i = 0; i < bytes.Length; i++)\n            {\n                builder.Append(bytes[i].ToString("x2"));\n            }\n            return builder.ToString();\n        }\n    }\n}\n\n// Usage\nclass Program\n{\n    static void Main()\n    {\n        string hardwareId = HardwareId.GetHardwareId();\n        Console.WriteLine("Hardware ID: " + hardwareId);\n    }\n}