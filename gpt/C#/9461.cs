ProcessStartInfo startInfo = new ProcessStartInfo("yourChildProcess.exe");\nstartInfo.RedirectStandardOutput = true;\nstartInfo.UseShellExecute = false;\nProcess process = Process.Start(startInfo);\n\nStreamReader reader = process.StandardOutput;\nstring output = reader.ReadToEnd();\nConsole.WriteLine(output);