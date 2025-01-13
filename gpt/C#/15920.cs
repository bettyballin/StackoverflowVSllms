using System;\nusing System.Collections.Generic;\n\npublic struct DataRow\n{\n    public string String1 { get; set; }\n    public string String2 { get; set; }\n    public int Number1 { get; set; }\n    public double Number2 { get; set; }\n\n    public DataRow(string string1, string string2, int number1, double number2)\n    {\n        String1 = string1;\n        String2 = string2;\n        Number1 = number1;\n        Number2 = number2;\n    }\n}\n\nclass Program\n{\n    static void Main()\n    {\n        List<DataRow> data = new List<DataRow>();\n\n        // Example of adding data\n        data.Add(new DataRow("value1", "value2", 10, 20.5));\n        data.Add(new DataRow("value3", "value4", 30, 40.5));\n\n        // Example of iterating through data\n        foreach (var row in data)\n        {\n            Console.WriteLine($"String1: {row.String1}, String2: {row.String2}, Number1: {row.Number1}, Number2: {row.Number2}");\n        }\n    }\n}