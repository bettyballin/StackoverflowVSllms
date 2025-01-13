using System.Diagnostics;\n\n// Get the current process\nProcess process = Process.GetCurrentProcess();\n\n// Get the CPU usage of the process\nfloat cpuUsage = process.TotalProcessorTime.Ticks / (float)Stopwatch.Frequency;\n\n// Log the CPU usage\nConsole.WriteLine($"CPU usage: {cpuUsage}%");