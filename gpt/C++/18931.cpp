// MyManagedClass.cpp\nusing namespace System;\n\npublic ref class MyManagedClass\n{\npublic:\n    // Static constructor for initialization\n    static MyManagedClass()\n    {\n        // Initialization code here\n        Console::WriteLine("Managed DLL loaded and initialized.");\n    }\n};