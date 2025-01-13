using System;\nusing System.Collections.Generic;\nusing System.Diagnostics;\n\nclass Program {\n    static void Main() {\n        List<char> letterRange = Enumerable.Range('a', 'z' - 'a' + 1).Select(i => (Char)i).ToList();\n\n        // Benchmarking foreach loop\n        Stopwatch stopwatchForeach = new Stopwatch();\n        stopwatchForeach.Start();\n        for (int i = 0; i < 10000; i++) { // Run multiple times for averaging\n            foreach (var range in letterRange) {\n                Console.Write(range + ",");\n            }\n        }\n        stopwatchForeach.Stop();\n\n        // Benchmarking ForEach method\n        Stopwatch stopwatchForEachMethod = new Stopwatch();\n        stopwatchForEachMethod.Start();\n        for (int i = 0; i < 10000; i++) { // Run multiple times for averaging\n            letterRange.ForEach(range => Console.Write(range + ","));\n        }\n        stopwatchForEachMethod.Stop();\n\n        Console.WriteLine($"Foreach loop took: {stopwatchForeach.ElapsedMilliseconds} ms");\n        Console.WriteLine($"ForEach method took: {stopwatchForEachMethod.ElapsedMilliseconds} ms");\n\n        // Note: Ensure to clear console output or disable it for accurate timing\n    }\n}