string generatedSql = "SELECT * FROM myTable WHERE id = 1";\nif (regex.IsMatch(generatedSql))\n{\n    Console.WriteLine("SQL syntax is valid");\n}\nelse\n{\n    Console.WriteLine("SQL syntax is invalid");\n}