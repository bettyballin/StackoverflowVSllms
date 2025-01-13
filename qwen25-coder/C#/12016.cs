using System;\n\nclass Program\n{\n    static void Main()\n    {\n        while (true)\n        {\n            Console.Clear();\n            Console.WriteLine("Welcome to the Interactive Command Prompt.");\n            Console.WriteLine("[1] Execute Command X with arg1");\n            Console.WriteLine("[2] Execute Command Y with arg2");\n            Console.WriteLine("[Q] Quit");\n\n            Console.Write("Please select an option: ");\n            string input = Console.ReadLine()?.ToUpper();\n\n            switch (input)\n            {\n                case "1":\n                    ExecuteCommandX("arg1");\n                    break;\n                case "2":\n                    ExecuteCommandY("arg2");\n                    break;\n                case "Q":\n                    Console.WriteLine("Exiting the application.");\n                    return;\n                default:\n                    Console.WriteLine("Invalid option. Please try again.");\n                    break;\n            }\n\n            Console.Write("Press any key to continue...");\n            Console.ReadKey();\n        }\n    }\n\n    static void ExecuteCommandX(string arg)\n    {\n        Console.WriteLine($"Executing Command X with argument: {arg}");\n        // Logic for command X\n    }\n\n    static void ExecuteCommandY(string arg)\n    {\n        Console.WriteLine($"Executing Command Y with argument: {arg}");\n        // Logic for command Y\n    }\n}