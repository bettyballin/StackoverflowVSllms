string url = "https://mail.google.com/?view=cm&fs=1&tf=1&to=t@example.com&su=boogaloo!!";\nstring chromePath = @"C:\Program Files\Google\Chrome\Application\chrome.exe";\n\nProcess process = new Process();\nprocess.StartInfo.FileName = chromePath;\nprocess.StartInfo.Arguments = url;\nprocess.StartInfo.UseShellExecute = false;\nprocess.Start();\n\nprocess.WaitForExit();