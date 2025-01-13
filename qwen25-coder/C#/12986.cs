using System;\nusing System.Collections.Concurrent;\nusing System.Threading;\nusing System.Threading.Tasks;\n\nclass Program\n{\n    private static SemaphoreSlim _semaphore = new SemaphoreSlim(3); // Allow 3 concurrent threads\n    private static BlockingCollection<string> _queue = new BlockingCollection<string>();\n\n    static async Task Main(string[] args)\n    {\n        // Simulate fetching data from a database and adding to the queue\n        for (int i = 0; i < 20; i++)\n        {\n            _queue.Add($"Item {i}");\n        }\n        _queue.CompleteAdding(); // Signal no more items will be added\n\n        List<Task> tasks = new List<Task>();\n        \n        while (_queue.TryTake(out var item))\n        {\n            await _semaphore.WaitAsync();\n            \n            tasks.Add(Task.Run(async () =>\n            {\n                try\n                {\n                    // Simulate running PowerShell command\n                    Console.WriteLine($"Processing {item} on thread {Thread.CurrentThread.ManagedThreadId}");\n                    await Task.Delay(1000); // Simulate work with a delay\n                    \n                    // Run your PowerShell command here using System.Management.Automation.PowerShell class\n                }\n                finally\n                {\n                    _semaphore.Release();\n                }\n            }));\n        }\n\n        await Task.WhenAll(tasks);\n        Console.WriteLine("All tasks completed.");\n    }\n}