process = new Process();\nprocess.StartInfo.UseShellExecute = true;\nprocess.StartInfo.RedirectStandardOutput = true;\nprocess.StartInfo.RedirectStandardError = true;\nprocess.StartInfo.CreateNoWindow = false;\nprocess.StartInfo.FileName = FileName;\nprocess.StartInfo.Arguments = Arguments;\nprocess.StartInfo.WorkingDirectory = WorkingDirectory;\nprocess.Start();