void InitFoo()\n{\n    static bool isInitialized = false;\n    if (isInitialized) return;\n    isInitialized = true;\n\n    // Actual code goes here.\n}