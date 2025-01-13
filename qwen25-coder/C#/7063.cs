using System;\nusing System.Diagnostics;\n\nnamespace cool {\n    class Program {\n        static void Main(string[] args) {\n            int[] x = new int[] { 3, 6, 9, 12 };\n            int[] y = new int[] { 3, 6, 9, 12 };\n\n            // Warm-up the JIT compiler\n            for (int i = 0; i < 4; i++) { }\n            foreach (var item in y) { }\n\n            Stopwatch stopwatch = new Stopwatch();\n\n            stopwatch.Start();\n            for (int i = 0; i < 4; i++) {\n                Console.WriteLine(x[i]);\n            }\n            stopwatch.Stop();\n            TimeSpan elapsedTime = stopwatch.Elapsed;\n\n            stopwatch.Restart();\n            foreach (var item in y) {\n                Console.WriteLine(item);\n            }\n            stopwatch.Stop();\n            TimeSpan elapsedTime2 = stopwatch.Elapsed;\n\n            Console.WriteLine("\nSummary");\n            Console.WriteLine("--------------------------\n");\n            Console.WriteLine("for:\t{0}\nforeach:\t{1}", elapsedTime, elapsedTime2);\n\n            Console.ReadKey();\n        }\n    }\n}