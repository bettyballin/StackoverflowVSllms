private readonly object _lockObject = new object();\n\npublic void ThreadSafeMethod()\n{\n    lock (_lockObject)\n    {\n        // Thread-safe code here\n    }\n}