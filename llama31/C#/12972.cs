using System.Diagnostics;\n\nvar stopwatch = Stopwatch.StartNew();\n// code to be profiled\nstopwatch.Stop();\nConsole.WriteLine($"Elapsed time: {stopwatch.Elapsed.TotalMilliseconds} ms");