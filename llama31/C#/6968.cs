class Program\n{\n    delegate void Action();\n    static void Main(string[] args)\n    {\n        List<Action> actions = new List<Action>();\n\n        for (int i = 0; i < 10; ++i)\n        {\n            int temp = i; // Create a temporary copy of i\n            actions.Add(() => Console.WriteLine(temp)); // Capture the copy\n        }\n\n        foreach (Action a in actions)\n            a();\n    }\n}