using System.Diagnostics;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        string url = "http://+:9001/";\n        string username = "YourUsername";\n\n        string command = $"netsh http add urlacl url={url} user={username}";\n        ProcessStartInfo psi = new ProcessStartInfo("cmd.exe", $"/c {command}")\n        {\n            Verb = "runas",\n            UseShellExecute = true\n        };\n\n        Process.Start(psi);\n    }\n}