gameServerProcess = new Process();\ngameServerProcess.StartInfo.UseShellExecute = false;\ngameServerProcess.StartInfo.RedirectStandardOutput = true;\ngameServerProcess.StartInfo.RedirectStandardError = true;\ngameServerProcess.StartInfo.RedirectStandardInput = true;\n\n// ...\n\ngameServerProcess.OutputDataReceived += new DataReceivedEventHandler(window.server_recievedOutputStream);\ngameServerProcess.ErrorDataReceived += new DataReceivedEventHandler(window.server_recievedErrorStream);\n\n// ...\n\ngameServerProcess.Start();\ngameServerProcess.BeginOutputReadLine();\ngameServerProcess.BeginErrorReadLine();