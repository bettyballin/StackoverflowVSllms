using System.Collections.Concurrent;\n\nConcurrentQueue<int> queue = new ConcurrentQueue<int>();\n\n// Enqueue an item\nqueue.Enqueue(1);\n\n// Try to dequeue an item\nif (queue.TryDequeue(out int result))\n{\n    Console.WriteLine($"Dequeued: {result}");\n}\nelse\n{\n    Console.WriteLine("Queue is empty.");\n}