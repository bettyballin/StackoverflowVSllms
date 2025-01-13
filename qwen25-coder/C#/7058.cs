public class Example {\n    public int Sum(int[] array) {\n        int sum = 0;\n        for (int i = 0; i < array.Length; i++) {\n            sum += array[i];\n        }\n        return sum;\n    }\n\n    // JIT optimizer can inline this method if it's small and frequently called, reducing method call overhead.\n    public void Print(int value) => Console.WriteLine(value);\n}\n\n// Usage\nExample example = new Example();\nexample.Print(example.Sum(new int[] { 1, 2, 3 }));