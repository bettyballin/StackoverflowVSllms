private static readonly object _lockObject = new object();\nprivate static int _sharedResource;\n\npublic void SomeMethod()\n{\n    lock (_lockObject)\n    {\n        // Access and modify the static variable safely\n        _sharedResource++;\n        // Your logic here\n    }\n}