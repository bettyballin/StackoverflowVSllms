using System.Diagnostics;\n\nclass Program\n{\n    static void Main()\n    {\n        string exeName = "path_to_your_exe.exe";\n        string arguments = "any_command_line_arguments";\n\n        using (Process process = new Process())\n        {\n            process.StartInfo.FileName = exeName;\n            process.StartInfo.Arguments = arguments;\n            process.Start();\n        }\n    }\n}