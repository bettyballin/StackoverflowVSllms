using System;\nusing System.Collections.Concurrent;\nusing System.Threading;\nusing System.Threading.Tasks;\n\npublic class FifoSynchronization\n{\n    private readonly SemaphoreSlim semaphore = new SemaphoreSlim(1, 1);\n    private readonly ConcurrentQueue<TaskCompletionSource<bool>> queue = new ConcurrentQueue<TaskCompletionSource<bool>>();\n\n    public async Task WaitAsync()\n    {\n        var tcs = new TaskCompletionSource<bool>();\n        queue.Enqueue(tcs);\n\n        if (queue.Count == 1)\n        {\n            tcs.SetResult(true);\n        }\n\n        await tcs.Task;\n        await semaphore.WaitAsync();\n    }\n\n    public void Release()\n    {\n        semaphore.Release();\n        if (queue.TryDequeue(out var tcs))\n        {\n            if (queue.TryPeek(out var nextTcs))\n            {\n                nextTcs.SetResult(true);\n            }\n        }\n    }\n}\n\npublic class Example\n{\n    private static readonly FifoSynchronization fifoSync = new FifoSynchronization();\n\n    public static async Task InsertBasicVariablesAsync(object param)\n    {\n        try\n        {\n            await fifoSync.WaitAsync();\n            // Insert into DB\n            Console.WriteLine("Inserting into DB");\n            await Task.Delay(1500); // Simulate long-running DB operation\n        }\n        catch (Exception ex)\n        {\n            // Handle exception\n        }\n        finally\n        {\n            fifoSync.Release();\n        }\n    }\n\n    public static void Main(string[] args)\n    {\n        Timer timer = new Timer(async _ => await InsertBasicVariablesAsync(null), null, 0, 1000);\n\n        Console.ReadLine(); // Keep the application running\n    }\n}