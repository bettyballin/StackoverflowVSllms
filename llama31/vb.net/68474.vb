Dim gameProcess As Process = New Process()\ngameProcess.StartInfo.UseShellExecute = False\ngameProcess.StartInfo.FileName = TextBox2.Text\ngameProcess.StartInfo.WorkingDirectory = Path.GetDirectoryName(TextBox2.Text)\ngameProcess.Start()\nDebug.Print("Game started")\ngameProcess.WaitForExit()\nDebug.Print("Game stopped")