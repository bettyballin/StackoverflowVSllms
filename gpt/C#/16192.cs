using System;\nusing System.Diagnostics;\n\npublic class NetworkSimulator\n{\n    public static void DisableNetwork()\n    {\n        ExecuteNetshCommand("interface set interface \"Wi-Fi\" admin=disable");\n    }\n\n    public static void EnableNetwork()\n    {\n        ExecuteNetshCommand("interface set interface \"Wi-Fi\" admin=enable");\n    }\n\n    private static void ExecuteNetshCommand(string arguments)\n    {\n        ProcessStartInfo psi = new ProcessStartInfo("netsh", arguments)\n        {\n            RedirectStandardOutput = true,\n            UseShellExecute = false,\n            CreateNoWindow = true\n        };\n\n        using (Process process = Process.Start(psi))\n        {\n            process.WaitForExit();\n            string output = process.StandardOutput.ReadToEnd();\n            Console.WriteLine(output);\n        }\n    }\n}\n\n// Example usage within a test\npublic class NetworkFailureTests\n{\n    public void TestDatabaseAccessDuringNetworkFailure()\n    {\n        try\n        {\n            NetworkSimulator.DisableNetwork();\n            // Now perform your DAL operations and check for expected behavior\n        }\n        finally\n        {\n            NetworkSimulator.EnableNetwork();\n        }\n    }\n}