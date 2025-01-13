using System;\nusing System.Threading;\n\nclass Program\n{\n    private static long _sharedCounter = 0;\n\n    static void Main()\n    {\n        // Start multiple threads to demonstrate atomicity\n        Thread[] threads = new Thread[10];\n        for (int i = 0; i < threads.Length; i++)\n        {\n            threads[i] = new Thread(IncrementCounter);\n            threads[i].Start();\n        }\n\n        // Wait for all threads to complete\n        foreach (var thread in threads)\n        {\n            thread.Join();\n        }\n\n        Console.WriteLine("Final counter value: " + _sharedCounter);\n    }\n\n    private static void IncrementCounter()\n    {\n        // Use Interlocked.Increment to ensure atomic operation\n        Interlocked.Increment(ref _sharedCounter);\n    }\n}