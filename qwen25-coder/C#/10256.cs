using System;\nusing System.Diagnostics;\n\npublic class AppTracker {\n    public static string GetCurrentProcesses() {\n        ProcessStartInfo psi = new ProcessStartInfo();\n        psi.FileName = "/bin/bash";\n        psi.Arguments = "-c \"ps -e\"";\n        psi.UseShellExecute = false;\n        psi.RedirectStandardOutput = true;\n        \n        Process p = Process.Start(psi);\n        string output = p.StandardOutput.ReadToEnd();\n        p.WaitForExit();\n\n        return output;\n    }\n\n    public static void Main(string[] args) {\n        while (true) {\n            Console.WriteLine(GetCurrentProcesses());\n            System.Threading.Thread.Sleep(900000); // Sleep for 15 minutes\n        }\n    }\n}