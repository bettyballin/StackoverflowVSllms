public class Program\n{\n    public static void Main()\n    {\n        MyNumber num1 = new MyNumber(10);\n        MyNumber num2 = new MyNumber(3);\n        MyNumber result = Calculator.Subtract(num1, num2);\n        Console.WriteLine(result.Value); // Output: 7\n    }\n}