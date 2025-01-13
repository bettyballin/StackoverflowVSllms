using CsvHelper;\nusing CsvHelper.Configuration;\nusing System.IO;\n\n// Define your CSV structure\npublic class MyCsvRecord\n{\n    public string Name { get; set; }\n    public int Age { get; set; }\n}\n\n// Read the CSV file\nvar config = new CsvConfiguration(CultureInfo.InvariantCulture)\n{\n    HasHeaderRecord = true,\n    MissingFieldFound = null\n};\n\nusing (var reader = new StreamReader("example.csv"))\nusing (var csv = new CsvReader(reader, config))\n{\n    var records = csv.GetRecords<MyCsvRecord>();\n\n    foreach (var record in records)\n    {\n        Console.WriteLine($"Name: {record.Name}, Age: {record.Age}");\n    }\n}