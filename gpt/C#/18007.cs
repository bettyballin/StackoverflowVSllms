var config = ConfigurationManager.GetSection("customSection") as CustomSection;\nif (config != null)\n{\n    Console.WriteLine($"Key: {config.Element.Key}, Value: {config.Element.Value}");\n}