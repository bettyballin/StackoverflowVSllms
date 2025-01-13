using System;\nusing System.Threading;\n\nclass Program\n{\n    static Mutex mutex = new Mutex(false, "MyApplicationMutex");\n\n    static void Main(string[] args)\n    {\n        if (!mutex.WaitOne(TimeSpan.Zero, false))\n        {\n            Console.WriteLine("Another instance is already running.");\n            return;\n        }\n\n        try\n        {\n            // Your application code here\n        }\n        finally\n        {\n            mutex.ReleaseMutex();\n        }\n    }\n}