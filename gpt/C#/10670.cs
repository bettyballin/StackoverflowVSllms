// UntrustedProcess.exe Code\nusing System;\n\npublic class Program\n{\n    public static void Main(string[] args)\n    {\n        string input = Console.ReadLine();\n        Console.WriteLine($"Received: {input}");\n        // Perform operations based on input, with limited permissions\n    }\n}