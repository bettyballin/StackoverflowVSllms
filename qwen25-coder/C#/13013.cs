int regularInt = 0; // This cannot be null.\nint? nullableInt = null; // This can be set to null.\n\nif (nullableInt.HasValue)\n{\n    Console.WriteLine("Value is: " + nullableInt.Value);\n}\nelse\n{\n    Console.WriteLine("The value is null.");\n}