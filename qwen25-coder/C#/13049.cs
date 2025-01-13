class Program {\n    static void Main(string[] args) {\n        var container = new WindsorContainer();\n        // Register the tax services as shown above\n\n        var calculator = new TaxCalculator(container);\n\n        decimal taxForUSA = calculator.GetTaxForCustomer(100M, "USA");\n        decimal taxForEU = calculator.GetTaxForCustomer(100M, "EU");\n\n        Console.WriteLine($"Tax for USA: {taxForUSA}");\n        Console.WriteLine($"Tax for EU: {taxForEU}");\n\n        container.Dispose();\n    }\n}