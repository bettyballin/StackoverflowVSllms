using System;\nusing System.Threading;\n\nclass Example\n{\n    private static int counter = 0;\n\n    static void Main()\n    {\n        Thread[] threads = new Thread[10];\n        \n        for (int i = 0; i < threads.Length; i++)\n        {\n            threads[i] = new Thread(IncrementCounter);\n            threads[i].Start();\n        }\n\n        foreach (Thread t in threads)\n        {\n            t.Join();\n        }\n\n        Console.WriteLine("Final counter value: " + counter);\n    }\n\n    private static void IncrementCounter()\n    {\n        for (int i = 0; i < 1000; i++)\n        {\n            Interlocked.Increment(ref counter);\n        }\n    }\n}