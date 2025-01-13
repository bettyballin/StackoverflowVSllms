using System;\nusing System.Diagnostics;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        Console.WriteLine("Threads in this process:");\n        foreach (ProcessThread thread in Process.GetCurrentProcess().Threads)\n        {\n            Console.WriteLine($"  {thread.Id} {thread.ThreadState} {thread.ThreadName}");\n        }\n        Console.ReadLine();\n    }\n}