public void Greet()\n{\n    Greet("Guest");\n}\n\npublic void Greet(string name)\n{\n    Console.WriteLine("Hello, " + name);\n}\n\n// Calling the method\nGreet();       // Output: Hello, Guest\nGreet("John"); // Output: Hello, Joh