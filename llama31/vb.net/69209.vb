Using Process As New System.Diagnostics.Process\n    Process.StartInfo.FileName = "setup.exe"\n    Process.StartInfo.WindowStyle = ProcessWindowStyle.Normal\n    Process.WaitForExit(60000) ' wait for 1 minute\nEnd Using