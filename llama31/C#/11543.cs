// Create a new profiling session\ndotTraceProfiler profiler = new dotTraceProfiler();\n\n// Start profiling\nprofiler.Start();\n\n// Run the application\nMyApplication.Run();\n\n// Stop profiling\nprofiler.Stop();\n\n// Get the profiling results\ndotTraceResults results = profiler.GetResults();\n\n// Analyze the results\nforeach (dotTraceThread thread in results.Threads)\n{\n    Console.WriteLine($"Thread {thread.Name} took {thread.TotalTime}ms");\n}