p.StartInfo.RedirectStandardError = true;\np.Start();\n\nstring errorOutput = p.StandardError.ReadToEnd();\np.WaitForExit();\n\nif (p.ExitCode != 0)\n{\n    // process failed\n    // log or update tasks table with errorOutput\n}