// JSON Serialization\n   var person = new { Name = "John", Age = 30 };\n   string json = JsonSerializer.Serialize(person);\n   var deserializedPerson = JsonSerializer.Deserialize<dynamic>(json);