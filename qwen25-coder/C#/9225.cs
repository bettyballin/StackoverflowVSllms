private readonly Object _lock = new Object();\nprivate ThirdPartyController _controller;\n\npublic void SafeMethodToAccessController()\n{\n    lock (_lock)\n    {\n        // Access or modify the non-thread-safe object here\n        _controller.PerformAction();\n    }\n}