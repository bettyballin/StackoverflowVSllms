public void PerformTaskWithTimeout()\n{\n    var lockObject = new object();\n    bool lockAcquired = false;\n\n    try\n    {\n        // Try to acquire the lock for 2 seconds\n        lockAcquired = Monitor.TryEnter(lockObject, TimeSpan.FromSeconds(2));\n\n        if (lockAcquired)\n        {\n            // Critical section code here\n        }\n        else\n        {\n            // Handle timeout scenario\n            Console.WriteLine("Failed to acquire lock within the timeout period.");\n        }\n    }\n    finally\n    {\n        if (lockAcquired)\n        {\n            Monitor.Exit(lockObject);\n        }\n    }\n}