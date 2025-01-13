using System;\nusing System.Globalization;\nusing System.Threading;\n\nclass Program\n{\n    static void Main()\n    {\n        CultureInfo currentCulture = Thread.CurrentThread.CurrentCulture;\n        string decimalSeparator = currentCulture.NumberFormat.NumberDecimalSeparator;\n        string csvSeparator = decimalSeparator == "," ? ";" : ",";\n\n        Console.WriteLine($"Decimal Separator: {decimalSeparator}");\n        Console.WriteLine($"CSV Separator: {csvSeparator}");\n    }\n}