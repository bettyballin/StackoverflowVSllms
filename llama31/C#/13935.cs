using CsvHelper;\nusing CsvHelper.Configuration;\n\nvar config = new CsvConfiguration(CultureInfo.InvariantCulture)\n{\n    HasHeaderRecord = true,\n    MissingFieldFound = null\n};\n\nusing (var reader = new StreamReader("example.csv"))\nusing (var csv = new CsvReader(reader, config))\n{\n    var records = csv.GetRecords<MyRecord>();\n    foreach (var record in records)\n    {\n        Console.WriteLine(record);\n    }\n}