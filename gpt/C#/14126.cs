using System.Collections.Concurrent;\n\npublic class UserQueue\n{\n    private static ConcurrentQueue<string> queue = new ConcurrentQueue<string>();\n    private static HashSet<string> activeUsers = new HashSet<string>();\n\n    public static void EnqueueUser(string userId)\n    {\n        if (!activeUsers.Contains(userId))\n        {\n            queue.Enqueue(userId);\n            activeUsers.Add(userId);\n        }\n    }\n\n    public static string DequeueUser()\n    {\n        if (queue.TryDequeue(out string userId))\n        {\n            activeUsers.Remove(userId);\n            return userId;\n        }\n        return null;\n    }\n\n    public static int GetUserPosition(string userId)\n    {\n        return Array.IndexOf(queue.ToArray(), userId) + 1;\n    }\n\n    public static int GetQueueLength()\n    {\n        return queue.Count;\n    }\n}