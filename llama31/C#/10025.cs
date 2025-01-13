using System;\nusing System.Globalization;\nusing System.AppDomain;\n\nclass LocalizationLauncher\n{\n    static void Main(string[] args)\n    {\n        if (args.Length != 2)\n        {\n            Console.WriteLine("Usage: LocalizationLauncher <culture_name> <application_path>");\n            return;\n        }\n\n        string cultureName = args[0];\n        string applicationPath = args[1];\n\n        try\n        {\n            CultureInfo culture = new CultureInfo(cultureName);\n\n            AppDomainSetup setup = new AppDomainSetup();\n            setup.ApplicationBase = AppDomain.CurrentDomain.BaseDirectory;\n            setup.Culture = culture;\n            setup.UICulture = culture;\n\n            AppDomain domain = AppDomain.CreateDomain("LocalizationDomain", null, setup);\n            domain.ExecuteAssembly(applicationPath);\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine("Error: " + ex.Message);\n        }\n    }\n}