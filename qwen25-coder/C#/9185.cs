Process p = new Process();\np.StartInfo.UseShellExecute = true; // Set this to true to use the 'print' verb properly\np.StartInfo.CreateNoWindow = false; // This must be false when UseShellExecute is true\np.StartInfo.FileName = fileName;\np.StartInfo.Verb = "print";\n\np.Start();