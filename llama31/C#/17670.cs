using System;\nusing System.Threading;\nusing System.Collections.Concurrent;\n\nclass Program\n{\n    static ConcurrentQueue<string> inputQueue = new ConcurrentQueue<string>();\n\n    static void ReadInputThread()\n    {\n        while (true)\n        {\n            string input = Console.ReadLine();\n            inputQueue.Enqueue(input);\n        }\n    }\n\n    static void Main(string[] args)\n    {\n        Thread inputThread = new Thread(ReadInputThread);\n        inputThread.IsBackground = true;\n        inputThread.Start();\n\n        while (true)\n        {\n            // Output stuff...\n            Console.WriteLine("Player killed Player2");\n\n            // Check for input\n            if (inputQueue.TryDequeue(out string input))\n            {\n                Console.WriteLine("Input received: " + input);\n                // Process input...\n            }\n\n            Thread.Sleep(100); // Simulate outputting every 100ms\n        }\n    }\n}