using System;\nusing System.Diagnostics;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        ProcessStartInfo startInfo = new ProcessStartInfo()\n        {\n            FileName = @"C:\Path\To\iexplore_original.exe",\n            Arguments = string.Join(" ", args),\n            UseShellExecute = true,\n            WindowStyle = System.Diagnostics.ProcessWindowStyle.Normal\n        };\n        \n        Process.Start(startInfo); // Start the original iexplore with passed arguments\n    }\n}