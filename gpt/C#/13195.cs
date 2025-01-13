using System;\nusing System.Globalization;\n\nclass Program\n{\n    static void Main()\n    {\n        decimal amount = -1234;\n        CultureInfo culture = new CultureInfo("en-US");\n        string formattedAmount = string.Format(culture, "{0:C2}", amount);\n        Console.WriteLine(formattedAmount);\n    }\n}