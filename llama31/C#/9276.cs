using System.Diagnostics;\n\nProcess process = new Process();\nprocess.StartInfo.FileName = "lighttpd.exe";\nprocess.StartInfo.WorkingDirectory = @"C:\Path\To\Project";\nprocess.Start();