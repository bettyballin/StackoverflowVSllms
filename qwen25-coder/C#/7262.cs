[Test]\npublic void GeneratedInsertShouldHaveValidSyntax() {\n    var generator = new SQLCodeGenerator();\n    var sql = generator.GenerateInsertStatement(new MyObject { Name = "John", Surname = "Doe", Age = 30 });\n    \n    var matches = Regex.Matches(sql, @"^INSERT INTO\s+MyObject\s*\((Name,", RegexOptions.IgnoreCase);\n    Assert.Greater(matches.Count, 0);\n}