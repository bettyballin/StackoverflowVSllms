using System;\n\nclass Program\n{\n    static void Main()\n    {\n        Console.Write("Enter your name and age (separated by space): ");\n        string[] inputs = Console.ReadLine().Split(' ');\n\n        string name = inputs[0];\n        int age = Convert.ToInt32(inputs[1]);\n\n        Console.WriteLine($"Hello, {name}! You are {age} years old.");\n    }\n}