// Start the process\nProcess P1 = new Process();\nP1.StartInfo.FileName = "myexe.exe";\nP1.Start();\n\n// Sometime later, when you want to kill the process\ntry\n{\n    if (!P1.HasExited)\n    {\n        P1.Kill();\n        P1.WaitForExit(); // Optional: wait for the process to exit completely\n    }\n}\ncatch (Exception ex)\n{\n    Console.WriteLine("An error occurred while terminating the process: " + ex.Message);\n}