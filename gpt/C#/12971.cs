using System;\nusing System.Diagnostics;\nusing System.Text;\n\nclass Program\n{\n    static void Main()\n    {\n        // Define the process start information\n        ProcessStartInfo startInfo = new ProcessStartInfo\n        {\n            FileName = "yourConsoleApp.exe", // Replace with the path to your console application\n            RedirectStandardOutput = true,\n            RedirectStandardError = true,\n            UseShellExecute = false,\n            CreateNoWindow = true\n        };\n\n        // Create the process\n        Process process = new Process\n        {\n            StartInfo = startInfo\n        };\n\n        // StringBuilder to capture the output\n        StringBuilder output = new StringBuilder();\n        StringBuilder error = new StringBuilder();\n\n        // Event handlers for capturing output and error\n        process.OutputDataReceived += (sender, e) => {\n            if (!string.IsNullOrEmpty(e.Data))\n            {\n                output.AppendLine(e.Data);\n                Console.WriteLine(e.Data); // Print to console (optional)\n            }\n        };\n\n        process.ErrorDataReceived += (sender, e) => {\n            if (!string.IsNullOrEmpty(e.Data))\n            {\n                error.AppendLine(e.Data);\n                Console.WriteLine(e.Data); // Print to console (optional)\n            }\n        };\n\n        // Start the process\n        process.Start();\n\n        // Begin reading the output asynchronously\n        process.BeginOutputReadLine();\n        process.BeginErrorReadLine();\n\n        // Wait for the process to exit\n        process.WaitForExit();\n\n        // Optionally, get the output and error strings\n        string outputString = output.ToString();\n        string errorString = error.ToString();\n    }\n}