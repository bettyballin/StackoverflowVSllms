foreach (Process p in Process.GetProcesses())\n{\n    if (String.Equals(p.ProcessName, name))\n    {\n        p.Kill();\n    }\n}