Dim startInfo As New ProcessStartInfo("firefox.exe")\nstartInfo.Arguments = "www.stackoverflow.com"\nstartInfo.WindowStyle = ProcessWindowStyle.Minimized\n\n' Start the process and capture the process object\nDim proc As Process = Process.Start(startInfo)\n\n' Access the StartInfo property of the process just started\nDebug.Print(String.Format("ProcessID={0}; Arguments={1}", _\n                          proc.Id, proc.StartInfo.Arguments))